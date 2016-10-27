package de.fhg.ids.comm.ws.protocol.rat.tpmobjects;

public class TPMS_RSA_PARMS extends TPMU_PUBLIC_PARMS {
	
	/*
	 * TPMS_RSA_PARMS Structure
	 * typedef struct {
	 *     TPMT_SYM_DEF_OBJECT symmetric;
	 *     TPMT_RSA_SCHEME     scheme;
	 *     TPMI_RSA_KEY_BITS   keyBits;
	 *     UINT32              exponent;
	 * } TPMS_RSA_PARMS;
	 */
	
	private TPMT_SYM_DEF_OBJECT symmetric;
	private TPMT_RSA_SCHEME scheme;
	private TPMI_RSA_KEY_BITS keyBits;
	private int exponent;
	
	public TPMT_SYM_DEF_OBJECT getSymmetric() {
		return symmetric;
	}

	public void setSymmetric(TPMT_SYM_DEF_OBJECT symmetric) {
		this.symmetric = symmetric;
	}

	public TPMT_RSA_SCHEME getScheme() {
		return scheme;
	}

	public void setScheme(TPMT_RSA_SCHEME scheme) {
		this.scheme = scheme;
	}

	public TPMI_RSA_KEY_BITS getKeyBits() {
		return keyBits;
	}

	public void setKeyBits(TPMI_RSA_KEY_BITS keyBits) {
		this.keyBits = keyBits;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}
	
	@Override
	public byte[] toBytes() {
		return ByteArrayUtil.buildBuf(symmetric, scheme, keyBits, exponent);
	}

	@Override
	public void fromBytes(byte[] source, int offset) {
        ByteArrayReadWriter brw = new ByteArrayReadWriter( source, offset );
        this.symmetric = new TPMT_SYM_DEF_OBJECT();
        brw.readStruct(this.symmetric);
        this.scheme = new TPMT_RSA_SCHEME();
        brw.readStruct(this.scheme);
        /*
        this.keyBits = new TPMI_RSA_KEY_BITS();
        brw.readStruct(this.keyBits);
        this.exponent = brw.readInt32();   */     
	}

	@Override
	public String toString() {
        return "TPMS_RSA_PARMS: \n" 
        		+ "symmetric = " + this.symmetric.toString() + "\n"
        		+ "scheme = " + this.scheme.toString() + "\n"
        		+ "keyBits = " + this.keyBits.toString() + "\n"
        		+ "exponent = " + exponent + "\n";
    }
}
