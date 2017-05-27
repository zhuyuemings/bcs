package com.ymzhu.controller;

import com.alibaba.fastjson.JSONObject;

public abstract class AbstractBaseController {

	protected interface AccessPrefix {
		String BCS = "/bcs";
	}

	protected interface SaveJSONResult {
		String STATUS = "status";
		String ERRORS = "errors";
		String MESSAGE = "message";
	}

	protected enum CommonStatus {
		SUCCESS(1, "登陆成功!"), FAILED(0, "登陆失败!"), NORECORD(-1, "用户不存在!"), MODIFY_SUCCESS(2, "修改成功!"), MODIFY_ERROR(3, "修改失败!");
		private int code;
		private String message;

		CommonStatus(int code, String message) {
			this.code = code;
			this.message = message;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	protected JSONObject getLoginJSONResult(int code) {
		JSONObject returnObj = new JSONObject();
		for (CommonStatus cs : CommonStatus.values()) {
			if (cs.getCode() == code) {
				returnObj.put(SaveJSONResult.STATUS, code);
				returnObj.put(SaveJSONResult.MESSAGE, cs.getMessage());
				break;
			}
		}
		return returnObj;
	}

}
