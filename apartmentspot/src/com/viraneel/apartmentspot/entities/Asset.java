package com.viraneel.apartmentspot.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;



@PersistenceCapable
public class Asset extends BaseEntity implements Comparable{

	private static DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key assetID;
    @Persistent
	private String assetNO;
    @Persistent
	private String assetName;
    @Persistent
	private int quantity;
    @Persistent
	private String Model;
    @Persistent
    private String asset_purchase_date;
    @Persistent
    private String asset_expiry_date;
    @Persistent
	private int totalassets;
    @Persistent
    private String asset_description;
    
    public Key getAssetID() {
		return assetID;
	}
	public void setAssetID(Key assetID) {
		this.assetID = assetID;
	}
	public String getAssetNO() {
		return assetNO;
	}
	public void setAssetNO(String assetNO) {
		this.assetNO = assetNO;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	
	public int getTotalAssets() {
		return totalassets;
	}
	
	public void setTotalAssets(int totalassets) {
		this.totalassets = totalassets;
	}
	
	public String get_Asset_Purchase_Date() {
		return asset_purchase_date;
	}
	
	public void set_Asset_Purchase_Date(Date asset_purchase_date) {
		this.asset_purchase_date = df.format(asset_purchase_date);
	}
		
	public String get_Asset_Expiry_Date() {
		return asset_expiry_date;
	}
	
	public void set_Asset_Expiry_Date(Date asset_expiry_date) {
		this.asset_expiry_date = df.format(asset_expiry_date);
	}
	
	public String get_Asset_Desc() {
		return asset_description;
	}
	
	public void set_Asset_Desc(String asset_description) {
		this.asset_description = asset_description;
	}
	
	public String get_Model() {
		return Model;
	}
	
	public void set_Asset_Model(String model) {
		this.Model = model;
	}
	public int getquantity() {
		return quantity;
	}
	
	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public int compareTo(Object o) {
		Asset b = (Asset) o;
		int returnval = this.assetID.compareTo(b.assetID);
		return returnval;
	}
	
		
}
