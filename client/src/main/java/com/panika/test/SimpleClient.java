package com.panika.test;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class SimpleClient {

    public static void main(String[] args) throws IOException {

        ClientTask clientTask1 = new ClientTask("1号");

    }


}
