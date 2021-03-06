package com.qingyuanos.openshiftapis.googleprotobufrpc;

import com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectResponse;
import com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.FindProjectRequest;
import com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.FindProjectResponse;

import io.grpc.ManagedChannel;
import io.grpc.internal.GrpcUtil;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.testing.TestUtils;

import io.netty.handler.ssl.SslContext;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocketFactory;

import com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest;
import com.qingyuanos.core.googleprotobuf.openshiftapis.ProjectAndBuild.CreateOriginProjectRequest.Builder;
import com.qingyuanos.core.googlerpc.openshiftapis.OpenshiftApplianceGrpc;

public class APIEngine {

	public CreateOriginProjectResponse createProject(String name, String[] finalizers) throws RuntimeException {
		Builder txDataBuilder = CreateOriginProjectRequest.newBuilder().setName(name);
		if (finalizers != null && finalizers.length > 0) {
			for (int i = 0; i < finalizers.length; ++i) {
				txDataBuilder.setFinalizers(i, finalizers[i]);
			}
		}

		CreateOriginProjectRequest txData = txDataBuilder.build();
		
		ManagedChannel channel = createChannel();
		if (channel == null) {
			throw new RuntimeException("Unexpected");
		}
		txrx(channel);

		CreateOriginProjectResponse rxData = blockingStub.createOriginProject(txData);
        
		return rxData;
	}

	public FindProjectResponse findProject(String name) throws RuntimeException {
		FindProjectRequest txData = FindProjectRequest.newBuilder().setName(name).build();
		
		ManagedChannel channel = createChannel();
		if (channel == null) {
			throw new RuntimeException("Unexpected");
		}
		txrx(channel);

		FindProjectResponse rxData = blockingStub.findProject(txData);
        
		return rxData;
	}
	
	private boolean useOkHttp;
	private String serverHost = "localhost";
	private int serverPort = 8080;
	private String serverHostOverride;
	private boolean useTls;
	private boolean useTestCa;
	
	public APIEngine(String serverHost, int serverPort) {
		this.serverHost = serverHost;
		this.serverPort = serverPort;	
		
/*		ManagedChannel channel = ManagedChannelBuilder.forAddress(serverHost, serverPort)
		        .usePlaintext(true)
		        .build();
*/		
	}

	protected ManagedChannel createChannel() {
		if (!useOkHttp) {
			InetAddress address;
			try {
				address = InetAddress.getByName(serverHost);
				if (serverHostOverride != null) {
					// Force the hostname to match the cert the server uses.
					address = InetAddress.getByAddress(serverHostOverride, address.getAddress());
				}
			} catch (UnknownHostException ex) {
				throw new RuntimeException(ex);
			}
			SslContext sslContext = null;
			if (useTestCa) {
				try {
					sslContext = GrpcSslContexts.forClient().trustManager(TestUtils.loadCert("ca.pem")).build();
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			}
			return NettyChannelBuilder.forAddress(new InetSocketAddress(address, serverPort))
					.flowControlWindow(65 * 1024)
					.negotiationType(useTls ? NegotiationType.TLS : NegotiationType.PLAINTEXT).sslContext(sslContext)
					.build();
		} else {
			OkHttpChannelBuilder builder = OkHttpChannelBuilder.forAddress(serverHost, serverPort);
			if (serverHostOverride != null) {
				// Force the hostname to match the cert the server uses.
				builder.overrideAuthority(GrpcUtil.authorityFromHostAndPort(serverHostOverride, serverPort));
			}
			if (useTls) {
				try {
					SSLSocketFactory factory = useTestCa
							? TestUtils.newSslSocketFactoryForCa(TestUtils.loadCert("ca.pem"))
							: (SSLSocketFactory) SSLSocketFactory.getDefault();
					builder.sslSocketFactory(factory);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			return builder.build();
		}
	}
 
	protected OpenshiftApplianceGrpc.OpenshiftApplianceStub asyncStub;
	protected OpenshiftApplianceGrpc.OpenshiftApplianceBlockingStub blockingStub;
	protected OpenshiftApplianceGrpc.OpenshiftApplianceFutureStub futureStub;
	
	private void txrx(ManagedChannel channel) {
	    blockingStub = OpenshiftApplianceGrpc.newBlockingStub(channel);
		asyncStub = OpenshiftApplianceGrpc.newStub(channel);
        futureStub = OpenshiftApplianceGrpc.newFutureStub(channel);
	}
}
