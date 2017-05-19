/**
 * 
 */
package com.grupoatrium.persistencia.impl;

/**
 * @author ilr00819
 *
 */
public class ConnectionMgrTest {
String driver;
String url;
String usuario;
String password;
/**
 * @return the driver
 */
public String getDriver() {
	return driver;
}
/**
 * @param driver the driver to set
 */
public void setDriver(String driver) {
	this.driver = driver;
}
/**
 * @return the url
 */
public String getUrl() {
	return url;
}
/**
 * @param url the url to set
 */
public void setUrl(String url) {
	this.url = url;
}
/**
 * @return the usuario
 */
public String getUsuario() {
	return usuario;
}
/**
 * @param usuario the usuario to set
 */
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "ConnectionMgr [driver=" + driver + ", url=" + url + ", usuario="
			+ usuario + ", password=" + password + "]";
}

}
