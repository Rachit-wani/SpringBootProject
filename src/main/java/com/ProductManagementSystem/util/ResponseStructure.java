package com.ProductManagementSystem.util;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ResponseStructure<T> {

	
private	int statuscode;
private	LocalDateTime localDateTime;
private	String message;
private	T data;

//
//public int getStatuscode() {
//	return statuscode;
//}
//public void setStatuscode(int statuscode) {
//	this.statuscode = statuscode;
//}
//public LocalDateTime getLocalDateTime() {
//	return localDateTime;
//}
//public void setLocalDateTime(LocalDateTime localDateTime) {
//	this.localDateTime = localDateTime;
//}
//public String getMessage() {
//	return message;
//}
//public void setMessage(String message) {
//	this.message = message;
//}
//public T getData() {
//	return data;
//}
//public void setData(T data) {
//	this.data = data;
//}
	
	
}
