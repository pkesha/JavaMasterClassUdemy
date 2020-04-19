package com.keshavarziparham;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;


public class Main {

    public static void main(String[] args) {
        try{
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i = 0; i < 10; i++){
                            String currentTime = "The time is: " + System.currentTimeMillis();

                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()){
                                //Writing from buffer into sinkChannel
                                sinkChannel.write(buffer);
                            }
                            //Need to flip buffer for next iteration of loop
                            buffer.flip();
                            //Thread sleeps for a chance to read the source channel
                            Thread.sleep(100);
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);
                        for (int i = 0; i < 10; i++){
                            int bytesread = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesread];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();

        } catch (IOException e){
            e.printStackTrace();
        }

//        try(//Two lines of code in the try with resources
//                FileOutputStream binFile = new FileOutputStream("data.dat");
//                FileChannel binChannel = binFile.getChannel();) {
//
//            ByteBuffer buffer = ByteBuffer.allocate(100);
//
//            byte[] outputBytes = "Hello World!".getBytes();
//            buffer.put(outputBytes);
//            long int1Pos = outputBytes.length;
//            long int2Pos = int1Pos + Integer.BYTES;
//            buffer.putInt(-98765);
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes2);
//            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
//            buffer.putInt(1000);
//            buffer.flip();
//
//            //Java NIO with seekable byte channel interface
//            binChannel.write(buffer);
//
//            //Since always reading and writing data sequentially, can use inputString
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//
//            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
//            FileChannel copyChannel = copyFile.getChannel();
//            //channel.position(0);
//            //Need to set the transfer position to zero in order to copy
//            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
//            System.out.println("Num transferred = " + numTransferred);
//
//            channel.close();
//            ra.close();
//            copyChannel.close();
//
//
//            } catch (IOException e){
//                e.printStackTrace();
    }
}
