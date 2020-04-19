package com.keshavarziparham;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/* NOTES FROM THIS LECTURE
channel.read(buffer) does not read from the buffer. It writes to it.
You read byte by byte from data.dat and it overwrites the buffer byte by byte.
And because buffer and outputBytes back each other, when you overwrite the content of buffer you also change the content of outputBytes.
(data.dat contains "Hello World" because of binChannel.write(buffer))

So when we didn't call buffer.flip(); the buffer pointer looked like this:
"abllo World!(buffer-pointer)"
when we called channel.read(buffer) the pointer is already at the end which means it can't overwrite anything.
(Note: it can't add anymore bytes because buffer is fixed length).

On the other hand when we called buffer.flip() the pointer looked like this:
"((buffer-pointer) a)bllo World!" (**buffer pointer is currently at first element.)
So it is now able to overwrite byte by byte.
Thus after channel.read(buffer) the output is "Hello World" which we read from data.dat.
 */


public class Main {

    public static void main(String[] args) {
        try(//Two lines of code in the try with resources
                FileOutputStream binFile = new FileOutputStream("data.dat");
                FileChannel binChannel = binFile.getChannel();) {

            ByteBuffer buffer = ByteBuffer.allocate(100);
            //Java IO
            //Create byte array
           // byte[] outputBytes = "Hello World!".getBytes();
            //byte[] outputBytes2 = "Nice to meet you".getBytes();
            //can chainthe putInt() methods
            //buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
            //buffer.flip();

            //Seekable byte channel methods - JAVA NIO
//            read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
//                               updates the position accordingly.
//                               Note that now we're talking about the channel's position, not the byte buffer's position.
//                               Of course, the bytes will be placed into the buffer starting at its current position.
//            write(ByteBuffer) - the same as read, except it writes. There's one exception.
//                              If a datasource is opened in APPEND mode, then the first write will take place starting
//                              at the end of the datasource, rather than at position 0. After the write, the position
//                              will be updated accordingly.
//            position() - returns the channel's position.
//            position(long) - sets the channel's position to the passed value.
//            truncate(long) - truncates the size of the attached datasource to the passed value.
//            size() - returns the size of the attached datasource

            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();

            //Java NIO with seekable byte channel interface
            binChannel.write(buffer);

            //Since always reading and writing data sequentially, can use inputString
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            //Reading in reverse - sequentially copy - this block has an underflow
            //The underflow error at line with getInt() for get int3

//            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            //sets position of int3 for the buffer to read
//            channel.position(int3Pos);
//            //Channel writes into the buffer
//            channel.read(readBuffer);
//            //reset position
//            readBuffer.flip();
//            //Display int3 - must use flip before (?)
//            System.out.println("int3 = " + readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(int2Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int2 " + readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(int1Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int1 = " + readBuffer.getInt());

            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
            FileChannel copyChannel = copyFile.getChannel();
            //channel.position(0);
            //Need to set the transfer position to zero in order to copy
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num transferred = " + numTransferred);

            channel.close();
            ra.close();
            copyChannel.close();

            //From L251 - writing sequentially
            //Calculating start positions
//            byte[] outputString = "Hello, World".getBytes();
//            long str1Pos = 0;
//            long newInt1Pos = outputString.length;
//            long newInt2Pos = newInt1Pos + Integer.BYTES;
//            byte[] outputString2 = "Nice to meet you".getBytes();
//            long str2Pos = newInt2Pos + Integer.BYTES;
//            long newInt3Pos = str2Pos + outputString2.length;
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            binChannel.position(newInt1Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            binChannel.position(newInt2Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(1000);
//            intBuffer.flip();
//            binChannel.position(newInt3Pos);
//            binChannel.write(intBuffer);
//
//            //Wrap takes care of creating and flipping the buffer
//            binChannel.position(str1Pos);
//            binChannel.write(ByteBuffer.wrap(outputString));
//            binChannel.position(str2Pos);
//            binChannel.write(ByteBuffer.wrap(outputString2));


//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);
//            System.out.println("inputString = " + new String(inputString));
//            System.out.println("int1 = " + readBuffer.getInt());
//            System.out.println("int2 = " + readBuffer.getInt());
//
//            byte[] inputString2 = new byte[outputBytes2.length];
//            readBuffer.get(inputString2);
//            System.out.println("inputString2 = " + new String(inputString2));
//            //System.out.println("int3 = " + readBuffer.getInt());

            //Commented out - will be using Java NIO
//            //Allocating buffer size
//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            //channel ra will read from buffer
//            channel.read(readBuffer);
//            //reset buffer pointer
//            readBuffer.flip();
//            //creating new array of type byte, has length size
//            byte[] inputString = new byte[outputBytes.length];
//            //Gets the byte array inputString into the buffer
//            readBuffer.get(inputString);
//            //Turns byte array into String
//            System.out.println("inputString = " + new String(inputString));
//            //reads the current int value then increments
//            System.out.println("int1 = " + readBuffer.getInt());
//            System.out.println("int2 = " + readBuffer.getInt());
//
//            //creates new buffer with the size of outputBytes2
//            byte[] inputString2 = new byte[outputBytes2.length];
//            //buffer gets the value of inputString2 - Is it also assinged the value?
//            //Since it increments, after the 2 ints is "Nice to meet you"
//            readBuffer.get(inputString2);
//            //converts it back to string for output
//            System.out.println("inputString2 = " + new String(inputString2));
//            System.out.println("int3 = " + readBuffer.getInt());



//            Going to write another String an integer
//
//            //creates a byte buffer from the bytebuffer.wrap and the byte array
//            //Using byte array as THE buffer
//            //Buffer's mark is undefined
//
//            //Wrap method resets buffer position to zero
//            //ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
//
//            //Changing from wrap to allocate - new buffer is created
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            //puts contents in buffer into outputBytes
//            buffer.put(outputBytes);
//
//            //We need to flip
//            buffer.flip();
//
//            int numBytes =  binChannel.write(buffer);
//            System.out.println("numBytes written was: " + numBytes);
//            //Finally, close input stream - can use try with resources
//
//            //Writing with Integer
//            /*This won't write anything because it needs to be reset
//            to zero to start reading the buffer (Flip method)*/
//            ByteBuffer intBuffer =  ByteBuffer.allocate(Integer.BYTES);
//            //Writes integer
//            intBuffer.putInt(245);
//            //The flip method
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            /*Exception overflow error.  Buffer overflows since it already allocated size
//            (ByteBuffer.allocate(Integer.BYTES)) and the position is near the bounds
//            need to flip before and then after the put method*/
//            intBuffer.flip();   //reset before
//            intBuffer.putInt(-98765);
//            intBuffer.flip();   //reset again for future use
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            //Random access file
////            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
////            byte[] b = new byte[outputBytes.length];
////            //Reads the length of the array from data.dat
////            ra.read(b);
////            System.out.println(new String(b));
////
////            long int1 = ra.readInt();
////            long int2 = ra.readInt();
////            System.out.println(int1);
////            System.out.println(int2);
//
////            //This will specify if the file stream is input or output
////            FileInputStream file = new FileInputStream("data.txt");
////            //One channel for RW
////            FileChannel channel = file.getChannel();
//
//            //R/W with Java NIO - writing and reading objects
////            Path dataPath = FileSystems.getDefault().getPath("data.txt");
////            //Converting Strings into bytes because the method works with bytes
////            //Third argument is there to append, by default it will truncate
////            Files.write(dataPath, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);
////            //UTF-8 character set is default, method is overloaded for passing 2nd param as different
////            //character set
////            List<String> lines = Files.readAllLines(dataPath);
////            for(String line : lines){
////                System.out.println(line);
//
//            //Same thing as above but with NIO
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            //Buffer is already defined above
//            FileChannel channel = ra.getChannel();
//            //Changed the array's values in memory
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            /*Without flip method, a and b will print out because
//            the buffer position was not reset*/
//            buffer.flip();
//            //long numBytesRead = channel.read(buffer);
//            //Now since it's defined, need ways to get access to the byte array
//            //System.out.println("outputBytes = " + new String(outputBytes));
//
//            long numBytesRead = channel.read(buffer);
//            if(buffer.hasArray()){
//                //System.out.println("byte buffer = " + new String(buffer.array()));
//                System.out.println("byte buffer = " + new String(outputBytes));
//            }
//
//            //Absolute read
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt(0));
//            System.out.println(intBuffer.getInt());
//
//
//            //Relative read
////            intBuffer.flip();
////            numBytes = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println(intBuffer.getInt());
////            numBytes = channel.read(intBuffer);
////            intBuffer.flip();
////            //reads the buffer
////            System.out.println(intBuffer.getInt());
//            channel.close();
//            ra.close();

            } catch (IOException e){
                e.printStackTrace();
        }
    }
}
