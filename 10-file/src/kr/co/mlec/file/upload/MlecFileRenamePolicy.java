package kr.co.mlec.file.upload;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MlecFileRenamePolicy implements FileRenamePolicy {
	
	public static void main(String[] args) {
		File f = new File("c:/upload/temp/test.txt");
		// f.getParent(); - c:/java-lec/upload
		// f.getName() - test.txt
		// c:/java-lec/upload/test.txt
		// c:/java-lec/upload/alkjcvoieno224vcew.txt
	}
	
	@Override
	public File rename(File file) {		//매개변수는 원본 file에 대한 정보 받아옴
		String parent = file.getParent();
		String name = file.getName();
		// 원본 파일의 확장자
		String ext = "";
		// name이 aaa.txt 인 경우
		
		// index는  3이 된다.(a.b.jpg 이럴수도 있으니까 마지막 .)
 		int index = name.lastIndexOf(".");
 		
		// 확장자가 있는 경우( index -1이 아닌 경우 )
		if (index != -1) {
			// ext는 .txt 가 된다.
			ext = name.substring(index);
		}
		
		// 고유한 파일 이름을 생성하기
		return new File(parent, UUID.randomUUID() + ext);
	}
}	








