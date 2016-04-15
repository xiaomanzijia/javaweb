package com.lsgx.admin.model;

import java.io.Serializable;

/**
 * 配置表
 */

public class Config implements Serializable {
	
	private static final long serialVersionUID = 1717537564381198655L;
	private Integer id;
	private String configKey;
	private String configValue;

	/**
	 * 是否多值 0：否 1：是
	 */
	private Integer multiValue;

	/**
	 * 是否非空 0：非空  1：可空
	 */
	private Integer empty;
	
	/**
	 * 正则验证
	 */
	private String regular;
	
	/**
	 * 验证错误提示语
	 */
	private String prompt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public Integer getMultiValue() {
		return multiValue;
	}

	public void setMultiValue(Integer multiValue) {
		this.multiValue = multiValue;
	}

	public Integer getEmpty() {
		return empty;
	}

	public void setEmpty(Integer empty) {
		this.empty = empty;
	}

	public String getRegular() {
		return regular;
	}

	public void setRegular(String regular) {
		this.regular = regular;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	@Override
	public String toString() {
		return "Config [id=" + id + ", configKey=" + configKey
				+ ", configValue=" + configValue + ", multiValue=" + multiValue
				+ ", empty=" + empty + ", regular=" + regular + ", prompt="
				+ prompt + "]";
	}

	
	
}
