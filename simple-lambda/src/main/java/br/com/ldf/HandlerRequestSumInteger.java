package br.com.ldf;

import br.com.ldf.dto.IntegerRecord;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

// Handler value: example.HandlerInteger
public class HandlerRequestSumInteger implements RequestHandler<IntegerRecord, Integer> {

  /**
   * Takes in an InputRecord, which contains two integers and a String.
   * Logs the String, then returns the sum of the two Integers.
   */
  @Override
  public Integer handleRequest(IntegerRecord event, Context context) {
    LambdaLogger logger = context.getLogger();
    logger.log("event: " + event);
    int result = event.x() + event.y();
    logger.log("result: " + result);
    return result;
  }
}
