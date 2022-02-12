# SpringBoot启动流程

SpringBoot版本2.5.3

## run方法执行代码

```java
public ConfigurableApplicationContext run(String... args) {
    	// ①开启计时器
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		DefaultBootstrapContext bootstrapContext = createBootstrapContext();
		ConfigurableApplicationContext context = null;
		configureHeadlessProperty();
    
    	// ②通过SpringFactoriesLoader获取所有spring.factories下所有SpringApplicationRunListener实现类，并将其实例化
		SpringApplicationRunListeners listeners = getRunListeners(args);
    	// 调用所有listeners的start()方法，发布SpringBoot应用开始启动事件
		listeners.starting(bootstrapContext, this.mainApplicationClass);
		try {
			ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
            
            // ③创建并设置该应用要使用的Environment（包括PropertySource以及profile），SpringApplicationRunListener监听器发布environmentPrepared()事件，广播environment准备完成
			ConfigurableEnvironment environment = prepareEnvironment(listeners, bootstrapContext, applicationArguments);
			configureIgnoreBeanInfo(environment);
			Banner printedBanner = printBanner(environment);
            
            // ④根据webApplicationType决定创建哪种类型的ApplicationContext对象
			context = createApplicationContext();
			context.setApplicationStartup(this.applicationStartup);
            
            // ⑤为Application加载environment，之后逐个执行ApplicationContextInitializer的initialize()方法，进一步封装ApplicationContext；
            // 调用SpringApplicationRunListener的contextPrepare()方法，发布上下文准备完成；
            // 初始化IoC容器，并调用SpringApplicationRunListener的contextLoaded()方法，发布上下文IoC加载完成；
			prepareContext(bootstrapContext, context, environment, listeners, applicationArguments, printedBanner);
            
            // ⑥初始化所有自动装配类，并调用ApplicationContext的refresh()方法
            // SpringBoot自动装配也是在这里完成加载的
			refreshContext(context);
            
            // ⑦遍历所有注册的ApplicationRunner和CommandLineRunner，并执行其run()方法
            // 该过程可以理解为是SpringBoot完成ApplicationContext初始化前的最后一步工作
            // 我们可以自己实现ApplicationRunner或CommandLineRunner，来对SpringBoot的启动过程进行扩展
			afterRefresh(context, applicationArguments);
			stopWatch.stop();
			if (this.logStartupInfo) {
				new StartupInfoLogger(this.mainApplicationClass).logStarted(getApplicationLog(), stopWatch);
			}
            
            // ⑧SpringApplicationRunListener发布started()事件，应用启动完成
			listeners.started(context);
			callRunners(context, applicationArguments);
		}
		catch (Throwable ex) {
			handleRunFailure(context, ex, listeners);
			throw new IllegalStateException(ex);
		}

		try {
			listeners.running(context);
		}
		catch (Throwable ex) {
			handleRunFailure(context, ex, null);
			throw new IllegalStateException(ex);
		}
		return context;
	}
```

