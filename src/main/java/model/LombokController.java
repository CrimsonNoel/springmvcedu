package model;


import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.LombokObject;

/*
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Data :위의 5개 전체
 */


@RestController
public class LombokController {
	
	
	@RequestMapping("/lombok/json")
	public LombokObject json(LombokObject  lo) {
		lo.setName("lombok name");
		lo.setAge(100);
		lo.setLine("lombok test 중입니다");
		return lo;
	}
	
	/* string의 한글을 보냈때에는 한글이 깨진다 
	 * 그러나 collection으로 보내면 한글이 깨지지 않는다
	 * 이뉴는 모르겠다 
	 * 아니면 아래와 같이 수정해야한다 
	 * <annotation-driven>
    <message-converters>
        <beans:bean class="org.springframework.http.converter.StringHttpMessageConverter">
            <beans:property name="supportedMediaTypes">
                <beans:list>
                	<beans:value>text/html;charset=UTF-8</beans:value>
                </beans:list>
            </beans:property>
        </beans:bean>
    </message-converters>
</annotation-driven>
	 */
	
	@RequestMapping("/lombok/string1")
	public List<String> string(LombokObject  lo) {
		lo.setName("lombok name");
		lo.setAge(100);
		lo.setLine("lombok test 중입니다");
		List li = new ArrayList();
		li.add(lo.toString());
		return li;
	}
	
	
	@RequestMapping("/lombok/string2")
	public byte[] string2(LombokObject  lo) {
		byte[] b=null;
		try {
			b = "한글 확인합니다".getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

}


