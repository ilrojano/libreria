/**
 * 
 */
package com.grupoatrium.persistencia.impl;

/**
 * @author ilr00819
 *
 */
public class LibrosDAO {
	
	private ConnectionMgr ConnMgr;

	/**
	 * @return the ConnMgr
	 */
	public ConnectionMgr getConnMgr() {
		return ConnMgr;
	}

	/**
	 * @param mgr the ConnMgr to set
	 */
	public void setConnMgr(ConnectionMgr ConnMgr) {
		this.ConnMgr = ConnMgr;
	}
}
