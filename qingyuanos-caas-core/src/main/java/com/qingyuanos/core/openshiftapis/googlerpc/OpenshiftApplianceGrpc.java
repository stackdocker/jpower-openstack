package com.qingyuanos.core.openshiftapis.googlerpc;

import static com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest;
import static com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * The Openshift Appliance service definition.
 * </pre>
 */
@javax.annotation.Generated(value = "stupid manual code than by gRPC proto compiler (version 0.14.1)", comments = "Source: manager-service.proto")
public class OpenshiftApplianceGrpc {

	private OpenshiftApplianceGrpc() {
	}

	public static final String SERVICE_NAME = "googlerpc.OpenshiftAppliance";

	// Static method descriptors that strictly reflect the proto.
	@io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
	public static final io.grpc.MethodDescriptor<com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest, com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse> METHOD_CREATE_ORIGINPROJECT = io.grpc.MethodDescriptor
			.create(io.grpc.MethodDescriptor.MethodType.UNARY,
					generateFullMethodName("googlerpc.OpenshiftAppliance", "CreateOriginProject"),
					io.grpc.protobuf.ProtoUtils.marshaller(
							com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest
									.getDefaultInstance()),
					io.grpc.protobuf.ProtoUtils.marshaller(
							com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse
									.getDefaultInstance()));

	/**
	 * Creates a new async stub that supports all call types for the service
	 */
	public static OpenshiftApplianceStub newStub(io.grpc.Channel channel) {
		return new OpenshiftApplianceStub(channel);
	}

	/**
	 * Creates a new blocking-style stub that supports unary and streaming
	 * output calls on the service
	 */
	public static OpenshiftApplianceBlockingStub newBlockingStub(io.grpc.Channel channel) {
		return new OpenshiftApplianceBlockingStub(channel);
	}

	/**
	 * Creates a new ListenableFuture-style stub that supports unary and
	 * streaming output calls on the service
	 */
	public static OpenshiftApplianceFutureStub newFutureStub(io.grpc.Channel channel) {
		return new OpenshiftApplianceFutureStub(channel);
	}

	/**
	 * <pre>
	 * The greeting service definition.
	 * </pre>
	 */
	public static interface OpenshiftAppliance {

		/**
		 * <pre>
		 * Sends a greeting
		 * </pre>
		 */
		public void createOriginProject(
				com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest request,
				io.grpc.stub.StreamObserver<com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse> responseObserver);
	}

	@io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1469")
	public static abstract class AbstractOpenshiftAppliance implements OpenshiftAppliance, io.grpc.BindableService {

		@java.lang.Override
		public void createOriginProject(
				com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest request,
				io.grpc.stub.StreamObserver<com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse> responseObserver) {
			asyncUnimplementedUnaryCall(METHOD_CREATE_ORIGINPROJECT, responseObserver);
		}

		@java.lang.Override
		public io.grpc.ServerServiceDefinition bindService() {
			return OpenshiftApplianceGrpc.bindService(this);
		}
	}

	/**
	 * <pre>
	 * The greeting service definition.
	 * </pre>
	 */
	public static interface OpenshiftApplianceBlockingClient {

		/**
		 * <pre>
		 * Sends a greeting
		 * </pre>
		 */
		public com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse createOriginProject(
				com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest request);
	}

	/**
	 * <pre>
	 * The greeting service definition.
	 * </pre>
	 */
	public static interface OpenshiftApplianceFutureClient {

		/**
		 * <pre>
		 * Sends a greeting
		 * </pre>
		 */
		public com.google.common.util.concurrent.ListenableFuture<com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse> createOriginProject(
				com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest request);
	}

	public static class OpenshiftApplianceStub extends io.grpc.stub.AbstractStub<OpenshiftApplianceStub>
			implements OpenshiftAppliance {
		private OpenshiftApplianceStub(io.grpc.Channel channel) {
			super(channel);
		}

		private OpenshiftApplianceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected OpenshiftApplianceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new OpenshiftApplianceStub(channel, callOptions);
		}

		@java.lang.Override
		public void createOriginProject(
				com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest request,
				io.grpc.stub.StreamObserver<com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse> responseObserver) {
			asyncUnaryCall(getChannel().newCall(METHOD_CREATE_ORIGINPROJECT, getCallOptions()), request,
					responseObserver);
		}
	}

	public static class OpenshiftApplianceBlockingStub extends io.grpc.stub.AbstractStub<OpenshiftApplianceBlockingStub>
			implements OpenshiftApplianceBlockingClient {
		private OpenshiftApplianceBlockingStub(io.grpc.Channel channel) {
			super(channel);
		}

		private OpenshiftApplianceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected OpenshiftApplianceBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new OpenshiftApplianceBlockingStub(channel, callOptions);
		}

		@java.lang.Override
		public com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse createOriginProject(
				com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest request) {
			return blockingUnaryCall(getChannel(), METHOD_CREATE_ORIGINPROJECT, getCallOptions(), request);
		}
	}

	public static class OpenshiftApplianceFutureStub extends io.grpc.stub.AbstractStub<OpenshiftApplianceFutureStub>
			implements OpenshiftApplianceFutureClient {
		private OpenshiftApplianceFutureStub(io.grpc.Channel channel) {
			super(channel);
		}

		private OpenshiftApplianceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected OpenshiftApplianceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new OpenshiftApplianceFutureStub(channel, callOptions);
		}

		@java.lang.Override
		public com.google.common.util.concurrent.ListenableFuture<com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse> createOriginProject(
				com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest request) {
			return futureUnaryCall(getChannel().newCall(METHOD_CREATE_ORIGINPROJECT, getCallOptions()), request);
		}
	}

	  private static final int METHODID_CREATE_ORIGINPROJECT = 0;

	  private static class MethodHandlers<Req, Resp> implements
	      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
	      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
	      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
	      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
	    private final OpenshiftAppliance serviceImpl;
	    private final int methodId;

	    public MethodHandlers(OpenshiftAppliance serviceImpl, int methodId) {
	      this.serviceImpl = serviceImpl;
	      this.methodId = methodId;
	    }

	    @java.lang.Override
	    @java.lang.SuppressWarnings("unchecked")
	    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
	      switch (methodId) {
	        case METHODID_CREATE_ORIGINPROJECT:
	          serviceImpl.createOriginProject((com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest) request,
	              (io.grpc.stub.StreamObserver<com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse>) responseObserver);
	          break;
	        default:
	          throw new AssertionError();
	      }
	    }

	    @java.lang.Override
	    @java.lang.SuppressWarnings("unchecked")
	    public io.grpc.stub.StreamObserver<Req> invoke(
	        io.grpc.stub.StreamObserver<Resp> responseObserver) {
	      switch (methodId) {
	        default:
	          throw new AssertionError();
	      }
	    }
	  }

	  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
	    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
	        METHOD_CREATE_ORIGINPROJECT);
	  }

	  public static io.grpc.ServerServiceDefinition bindService(
	      final OpenshiftAppliance serviceImpl) {
	    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME/*getServiceDescriptor()*/)
	        .addMethod(
	          METHOD_CREATE_ORIGINPROJECT,
	          asyncUnaryCall(
	            new MethodHandlers<
	            com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest,
	            com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse>(
	                serviceImpl, METHODID_CREATE_ORIGINPROJECT)))
	        .build();
	  }
}
