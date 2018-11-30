# Micronaut + Kotlin

Async event listener not working in Kotlin.
Example illustrates problem with Micronaut async event listener.

1. declare @EventListener @Async fun onStartup() (public by default)

```bash
...
> Task :discoverMainScriptsExtensions
> Task :kaptGenerateStubsKotlin
e: /home/rgai/Projects/mn-eventlister-async/build/tmp/kapt3/stubs/main/mn/eventlister/async/StartupListener.java:16: error: Public method defines AOP advice
but is declared final. Either make the method non-public or apply AOP advice only to public methods declared on class.
    public final void onStartup(@org.jetbrains.annotations.NotNull()
...
```

2. Make this method private

```
private fun onStartup(event: ServerStartupEvent) { ... }
```

3. Error: it never gets called

4. Expected behaviour: better error message or fix it otherwise so it will be called anyways

5. Workaround: declare class and method as open (i.e. not final in Java terminology)
