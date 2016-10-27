package de.fhg.ids.comm.ws.protocol.rat.tpmobjects;

public class TPM2B_DIGEST extends StandardTPMStruct {
	
	/*
	 * TPM2B_DIGEST Structure
	 * typedef struct 
	 *     UINT16 size;
	 *     BYTE   buffer[sizeof(TPMU_HA)];
	 * } TPM2B_DIGEST;
	 */

	private byte[] buffer = new byte[0];
	
	public TPM2B_DIGEST() {
	}
	
	public TPM2B_DIGEST(byte[] buffer) {
		this.setBuffer(buffer);
	}
	
	public byte[] getBuffer() {
		return buffer;
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}

	public int getBufferLength() {
		return this.buffer.length;
	}

	@Override
	public byte[] toBytes() {
		int bufferLength = this.getBufferLength();
		return ByteArrayUtil.buildBuf(bufferLength, this.buffer);
	}

	@Override
	public void fromBytes(byte[] source, int offset) {
		ByteArrayReadWriter brw = new ByteArrayReadWriter( source, offset );
		short keyLength = brw.readShort();
        this.setBuffer(brw.readBytes(keyLength));
	}

	public String toString() {
		return "TPM2B_DIGEST (" + this.getBufferLength() + " bytes): "
	            + ByteArrayUtil.toPrintableHexString(this.buffer);
	}
}
