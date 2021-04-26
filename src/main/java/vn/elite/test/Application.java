package vn.elite.test;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8088).addService(new VesEventCollectorImpl()).build();
        server.start();
        server.awaitTermination();
    }
}
