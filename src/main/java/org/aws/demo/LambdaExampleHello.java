package org.aws.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Hello world!
 *
 */
public class LambdaExampleHello implements RequestHandler<Object, Object>
{

    public Object handleRequest(Object o, Context context) {
        System.out.println("Hello World");
        System.out.println("request >>>"+o.toString());
        System.out.println("context >>>"+context.getAwsRequestId());
        System.out.println("context >>>"+context.getFunctionName());
        return null;
    }
}
