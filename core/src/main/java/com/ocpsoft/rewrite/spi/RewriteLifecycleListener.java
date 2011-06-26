/*
 * Copyright 2011 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ocpsoft.rewrite.spi;

import javax.servlet.FilterChain;

import com.ocpsoft.rewrite.event.InboundRewriteEvent;
import com.ocpsoft.rewrite.pattern.Specialized;
import com.ocpsoft.rewrite.pattern.Weighted;

/**
 * Listens to rewrite life-cycle events.
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public interface RewriteLifecycleListener<T extends InboundRewriteEvent<?, ?>>
         extends Specialized<InboundRewriteEvent<?, ?>>,
         Weighted
{
   /**
    * Invoked before {@link RequestCycleWrapper} services are processed.
    */
   void beforeRewriteLifecycle(T event);

   /**
    * Invoked after {@link RequestCycleWrapper} services are processed, but before {@link RewriteProvider} services are
    * processed.
    */
   void beforeRewrite(T event);

   /**
    * Invoked after {@link RewriteProvider} services are processed, but before control of the request cycle is passed to
    * the application via {@link FilterChain#doFilter(IN, OUT)}
    */
   void afterRewrite(T event);

   /**
    * Invoked after application has returned control of the request to the rewrite engine, but before the rewrite engine
    * passes control of the application to other filters in the application chain.
    */
   void afterRewriteLifecycle(T event);
}
