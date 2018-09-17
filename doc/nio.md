1. nio features
- standard io works with byte stream and character streams while nio works with channels and buffers
- standard io is blocking io while nio non-blocking
- nio = channels + buffers + selectors

2. nio starts with **Channel**, data can be read into a **Buffer** via Channel, also can be written from Buffer into Channel.

3. A **Selector** allows a single thread to handle multiple Channels

4. common implementation of Channel.
- FileChannel, read/write from/to files
- DatagramChannel, read/write data over network via UDP
- SocketChannel, read/write data over network via TCP
- SocketServerChannel, listen for connection(channel) request(TPC)

5. basic buffer usage
- write to buffer
- buffer.flip(): switch buffer from writing mode into reading mode
- read from buffer
- buffer.clear() / buffer.compact(): **clear()** clears all the data while **compact()** clears read data moving unread to beginning.

note: properties of buffer
- capacity: fixed size of the buffer
- position: in write mode, position increase as data write in, after **flip()**, position is reset to 0 and increase again as you read
- limit: in write mode, limit is the same as capacity, after **flip()**, limit is set to position while position set to 0, in read mode, you can read maximum of limit bytes of data.

6. common implementation of Buffer, Buffer.allocate() to get the buffer obj
- ByteBuffer:
- CharBuffer:
- ...

common api of buffer
- rewind(): reset position back to 0, allowing re-read
- mark(): mark current position and call reset() later to set position back to mark
- clean(): position = 0, limit = capacity
- equals(): true if remaining bytes/cahrs ... are equal

7. scatter/gather
- scatter: read operation that reads into more than one buffer
- gather: write operation that writes data from more than one buffer to one channel
```
ByteBuffer header = ByteBuffer.allocate(128);
ByteBuffer body   = ByteBuffer.allocate(1024);

ByteBuffer[] bufferArray = { header, body };
// scatter read, fill first buffer first and then fill next buffer
channel.read(bufferArray);
```

8. using selector
```
// create a selector
Selector selector = Selector.open();

// register a channel, the channel must be non-blocking, since
// FileChannel is blocking, can't be used with selector
channel.configureBlocking(false);
SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
```
> note: a channel fires an event when it's ready. **SelectionKey** in register() mark the ready event.

- SelectionKey.OP_CONNECT
- SelectionKey.OP_ACCEPT
- SelectionKey.OP_READ
- SelectionKey.OP_WRITE
```
// register more than one event
int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
```
subscribe events
```
// block until at least one channel is ready
selector.select();
// block for a maximum of timeout mili-seconds
selector.select(long timeiout);
// doesn't block at all
selector.selectNow();

// determine which channels are ready by using the
// key (return value of register())
Set<SelectionKey> selectedKeys = selector.selectedKeys();

Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

while(keyIterator.hasNext()) {
    
    SelectionKey key = keyIterator.next();

    if(key.isAcceptable()) {
        // a connection was accepted by a ServerSocketChannel.

    } else if (key.isConnectable()) {
        // a connection was established with a remote server.

    } else if (key.isReadable()) {
        // a channel is ready for reading

    } else if (key.isWritable()) {
        // a channel is ready for writing
    }

    keyIterator.remove();
}
```


