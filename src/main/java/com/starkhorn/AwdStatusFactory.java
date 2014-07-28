package com.starkhorn;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class AwdStatusFactory {
	
	private Map<String, Properties> workTypeToStatusMapping = new HashMap<String, Properties>();

	public AwdStatus createStatusForWorkTypeAndCode(String workType, String code) {
		return new AwdStatus(workType, code);
	}
	
	public void setWorkTypeToStatusMapping(Map<String, Properties> workTypeToStatusMapping) {
		this.workTypeToStatusMapping = workTypeToStatusMapping;
	}

	public class AwdStatus {

		private String workType;
		private String code;

		private AwdStatus(String workType, String code) {
			this.workType = workType;
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}

		public String getName() {
			return getStatusMappingForWorkType().getProperty(this.code);
		}

		private Properties getStatusMappingForWorkType() {
			return workTypeToStatusMapping.get(this.workType);
		}

	}

}
