package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class DocumentUpload {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int documnet_id;
	private int customer_id;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] address_proof;
	@Lob
	private byte[] thumb;
	public int getDocumnet_id() {
		return documnet_id;
	}
	public void setDocumnet_id(int documnet_id) {
		this.documnet_id = documnet_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public byte[] getSignature() {
		return signature;
	}
	public void setSignature(byte[] signature) {
		this.signature = signature;
	}
	public byte[] getAddress_proof() {
		return address_proof;
	}
	public void setAddress_proof(byte[] address_proof) {
		this.address_proof = address_proof;
	}
	public byte[] getThumb() {
		return thumb;
	}
	public void setThumb(byte[] thumb) {
		this.thumb = thumb;
	}
	
	
}
