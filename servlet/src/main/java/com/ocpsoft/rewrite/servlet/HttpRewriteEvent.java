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
package com.ocpsoft.rewrite.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocpsoft.rewrite.event.MutableRewriteEvent;

/**
 * Rewrite event for an {@link HttpServletRequest}, {@link HttpServletResponse} lifecycle.
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public interface HttpRewriteEvent extends MutableRewriteEvent<HttpServletRequest, HttpServletResponse>
{
   /**
    * If the {@link HttpServletResponse} is not already committed, issue a Temporary Redirect (302) and call
    * {@link #abort()}.
    */
   public void redirectTemporary(final String location);

   /**
    * If the {@link HttpServletResponse} is not already committed, issue a Permanent Redirect (302) and call
    * {@link #abort()}.
    */
   public void redirectPermanent(final String location);

   /**
    * If the {@link HttpServletResponse} is not already committed, send an HTTP status code and and call
    * {@link #abort()}.
    */
   public void sendErrorCode(int code);

   /**
    * If the {@link HttpServletResponse} is not already committed, send an HTTP status code and and call
    * {@link #abort()}. Provide the given message to the browser.
    */
   public void sendErrorCode(int code, String message);
}
