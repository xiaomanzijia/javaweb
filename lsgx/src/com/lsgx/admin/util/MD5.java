package com.lsgx.admin.util;

/**
 * Created by IntelliJ IDEA.
 * User: Watson
 * Date: 11-12-8  下午4:17
 * To change this template use File | Settings | File Templates.
 */

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Provides a static utility interface to an MD5 digest algorithm obtained
 * through the java.security.MessageDigest spi. * Database end-users may wish to
 * access the services of this class * to provide, for instance, application
 * user lookup tables with * one-way password encryption. For example: * -- DDL
 * CREATE TABLE USERS(UID INTEGER IDENTITY, UNAME VARCHAR, UPASS VARCHAR,
 * UNIQUE(UNAME)) CREATE ALIAS MD5 FOR "org.hsqldb.lib.MD5.encodeString" -- DML
 * & DQL INSERT INTO USERS(UNAME, UPASS) VALUES('joe', MD5('passwd')) UPDATE
 * USERS SET UPASS = MD5('newpasswd') WHERE UNAME = 'joe' AND UPASS =
 * MD5('oldpasswd') SELECT UID FROM USERS WHERE UNAME = 'joe' AND UPASS =
 * MD5('logonpasswd')
 * 
 * NOTE: * Although it is possible that a particular JVM / application
 * installation may * encounter NoSuchAlgorithmException when attempting to get
 * a jce MD5 message * digest generator, the likelyhood is very small for almost
 * all JDK/JRE 1.1 * and later JVM implementations, as the Sun java.security
 * package has come, * by default, with a jce MD5 message digest generator since
 * JDK 1.1 was * released. The HSLQLDB project could have provided an MD5
 * implementation to * guarantee presence, but this class is much more
 * lightweight and still allows * clients to install / use custom
 * implementations through the * java.security.MessageDigest spi, for instance
 * if there is no service * provided by default under the target JVM of choice
 * or if a client has * developed / provides, say, a faster MD5 message digest
 * implementation. * In short, this class is a convenience that allows HSQLDB
 * SQL Function and * Stored Procedure style access to any underlying MD5
 * message digest algorithm * obtained via the java.security.MessageDigest spi *
 * *
 * 
 * @author boucherb@users.sourceforge.net *
 * @version 1.7.2 *
 * @since 1.7.2
 */
public final class MD5 {
	/** * The jce MD5 message digest generator. */
	private static MessageDigest md5;

	public static final String encodeString(String string, String encoding)
			throws RuntimeException {
		return StringConverter.byteToHex(digestString(string, encoding));
	}

	/**
	 * md5加密
	 * 
	 * @param str
	 * @return
	 */
	public static final String encodeString(String str) {
		return encodeString(str, Constant.GBK.name());

	}

	/**
	 * * Retrieves a byte sequence representing the MD5 digest of the *
	 * specified character sequence, using the specified encoding to * first
	 * convert the character sequence into a byte sequence. * If the specified
	 * encoding is null, then ISO-8859-1 is * assumed. * *
	 * 
	 * @param string
	 *            the string to digest. *
	 * @param encoding
	 *            the character encoding. *
	 * @return the digest as an array of 16 bytes. *
	 * @throws if
	 *             an MD5 digest * algorithm is not available through the *
	 *             java.security.MessageDigest spi or the requested * encoding
	 *             is not available
	 */
	public static byte[] digestString(String string, String encoding)
			throws RuntimeException {
		byte[] data;
		if (encoding == null) {
			encoding = "ISO-8859-1";
		}
		try {
			data = string.getBytes(encoding);
		} catch (UnsupportedEncodingException x) {
			throw new RuntimeException(x.toString());
		}
		return digestBytes(data);
	}

	/**
	 * * Retrieves a byte sequence representing the MD5 digest of the *
	 * specified byte sequence. * *
	 * 
	 * @param data
	 *            the data to digest. *
	 * @return the MD5 digest as an array of 16 bytes. *
	 * @throws if
	 *             an MD5 digest * algorithm is not available through the *
	 *             java.security.MessageDigest spi
	 */
	public static final byte[] digestBytes(byte[] data) throws RuntimeException {
		synchronized (MD5.class) {
			if (md5 == null) {
				try {
					md5 = MessageDigest.getInstance("MD5");
				} catch (NoSuchAlgorithmException e) {
					throw new RuntimeException(e.toString());
				}
			}
			return md5.digest(data);
		}
	}
	
}
