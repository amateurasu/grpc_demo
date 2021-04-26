package vn.elite.test;

import com.viettel.ems.ProtobufGateway;
import com.viettel.ems.VesEventCollectorGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.onap.ves.DCAE;

@Slf4j
public class VesEventCollectorImpl extends VesEventCollectorGrpc.VesEventCollectorImplBase {

    @Override
    public void collect(DCAE.VesEvent request, StreamObserver<ProtobufGateway.VesEventReply> responseObserver) {
        super.collect(request, responseObserver);
        responseObserver.onNext(null);
        responseObserver.onCompleted();
        log.info("request {}", request);
    }
}
