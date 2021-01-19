package com.morecleanwater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.morecleanwater.model.Task;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received the request");
		Task t1 = new Task("1", "Finish react components", false);
		Task t2 = new Task("2", "CRUD category", true);
		List<Task> tasks = new ArrayList<>();
		tasks.add(t1);
		tasks.add(t2);

		return ApiGatewayResponse.builder().setStatusCode(200).setObjectBody(tasks).build();
	}
}
