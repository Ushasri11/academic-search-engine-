package com.academicSearchEngine.search.cache;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Decorates a thread factory with named threads.
 */
public class NamedThreadFactory implements ThreadFactory {
  
  /**
   * The name.
   *
   * @uml.property  name="name"
   */
private final String name;
  
  /**
   * The thread factory.
   *
   * @uml.property  name="threadFactory"
   */
private final ThreadFactory threadFactory;

  /**
   * Creates a new NamedThreadFactory object.
   * 
   * @param threadFactory Factory to decorate
   * @param name Name
   */
  public NamedThreadFactory(ThreadFactory threadFactory, String name) {
    this.threadFactory = threadFactory;
    this.name = name + " ";
  }

  /**
   * Decorates the given thread pool executor with a named thread factory.
   *
   * @param executor Executor to decorate.
   * @param pName the name
   * @return The decorated executor
   */
  public static ThreadPoolExecutor decorate(ThreadPoolExecutor executor, String pName) {
    executor.setThreadFactory(new NamedThreadFactory(executor.getThreadFactory(), pName));
    return executor;
  }

  /**
   * New thread.
   *
   * @param runnable the runnable
   * @return the thread
   */
  @Override
  public Thread newThread(Runnable runnable) {
    Thread thread = threadFactory.newThread(runnable);
    thread.setName(name + thread.getName());
    return thread;
  }
}