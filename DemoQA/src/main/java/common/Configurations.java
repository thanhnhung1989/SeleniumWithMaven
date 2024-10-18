package common;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

public class Configurations {
	
	String configFile;
	
	public Configurations(String configs) {
		this.configFile = configs;
	}

	// đọc file cấu hình
	//lấy giá trị tương ứng với 1 key(configName) trong file cấu hình và trả về giá trị đó.

	public String getConfigValueByKey( String configName) {
		String configValue = "";
		try {
			InputStream input = new FileInputStream(configFile);// Mở file cấu hình
			Properties prop = new Properties();// Khởi tạo đối tượng Properties, sẽ chứa nội dung file cấu hình
			 prop.load(input);	// Đọc nội dung file và nạp vào đối tượng prop
			 configValue = prop.getProperty(configName);// Lấy giá trị tương ứng với key "configName" từ prop
		}
		catch(Exception e) {
			System.out.println("File not found");
			
		}
		
		return configValue;
	}

}
