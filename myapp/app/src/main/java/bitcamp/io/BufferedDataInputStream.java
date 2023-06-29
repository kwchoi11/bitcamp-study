package bitcamp.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedDataInputStream extends FileInputStream {

  byte[] buf = new byte[8192];
  int size; // 배열에 저장되어 있는 바이트의 수
  int cursor; // 바이트 읽은 배열의 위치

  public BufferedDataInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  public short readShort() throws IOException {
    return (short) (this.read() << 8 | this.read());
  }

  public int readInt() throws IOException {
    return this.read() << 24 | this.read() << 16 | this.read() << 8 | this.read();
  }

  public long readLong() throws IOException {
    return (long) this.read() << 56 | (long) this.read() << 48 | (long) this.read() << 40
        | (long) this.read() << 32 | (long) this.read() << 24 | (long) this.read() << 16
        | (long) this.read() << 8 | this.read();
  }

  public char readChar() throws IOException {
    return (char) (this.read() << 8 | this.read());
  }

  public String readUTF() throws IOException {
    int length = this.read() << 8 | this.read();
    byte[] buf = new byte[length];
    this.read(buf);
    return new String(buf, "UTF-8");
  }

}


