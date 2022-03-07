package com.tts.API;

//네이버 음성합성 Open API 예제
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/tts/*")
//@CrossOrigin(origins = "http://localhost:7777/tts.mp3")
public class TTS {
	
//	@PostMapping("/test")
//	public ArrayList<HashMap<String, Object>> test(@RequestBody HashMap<String, Object> requestJsonHashMap) throws Exception{
//
//		//response Data
//		ArrayList<HashMap<String, Object>> rtnArray = new ArrayList<HashMap<String, Object>>();
//		HashMap<String, Object> rtnMap = new HashMap<String, Object>();
//
//		rtnMap.put("text", requestJsonHashMap.get("data"));    
//		rtnArray.add(rtnMap);
//		rtnMap.get("text");
//		//System.out.println(rtnMap.get("text"));
//		String tts = (String) rtnMap.get("text");
//		//System.out.println(tts);
//		return rtnArray; 
//	}	
	
	@PostMapping("/server")
	//@CrossOrigin(origins = "http://localhost:8085")
    public  void getTTShelper(@RequestBody HashMap<String, Object> requestJsonHashMap ) {
	HashMap<String, Object> rtnMap = new HashMap<String, Object>();
	rtnMap.put("text", requestJsonHashMap.get("data1"));
	rtnMap.put("voice", requestJsonHashMap.get("data2"));
	rtnMap.put("speed", requestJsonHashMap.get("data3")); 
	rtnMap.put("volume", requestJsonHashMap.get("data4")); 
	String tts = (String) rtnMap.get("text");
	String voice = (String) rtnMap.get("voice");
	String speed = (String) rtnMap.get("speed");
	String volume = (String) rtnMap.get("volume");
     String clientId = "zvyh4atvgh";//애플리케이션 클라이언트 아이디값";
     String clientSecret = "MWlUUGIrdLgCIE4ASgRrkIRn4XdQFfwFwmceH9vN";//애플리케이션 클라이언트 시크릿값";
     System.out.println(rtnMap);
     System.out.println("전달받은 값 : " + tts);
     try {
         String text = URLEncoder.encode(tts, "UTF-8"); // 13자
         String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
         URL url = new URL(apiURL);
         HttpURLConnection con = (HttpURLConnection)url.openConnection();
         con.setRequestMethod("POST");
         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
         con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
         // post request
         String postParams = "speaker="+voice+"&volume="+volume+"&speed="+speed+"&pitch=0&format=mp3&text=" + text;
         con.setDoOutput(true);
         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
         wr.writeBytes(postParams);
         wr.flush();
         wr.close();
         int responseCode = con.getResponseCode();
         BufferedReader br;
         if(responseCode==200) { // 정상 호출
             InputStream is = con.getInputStream();
             int read = 0;
             byte[] bytes = new byte[1024];
             // 랜덤한 이름으로 mp3 파일 생성
             String tempname = Long.valueOf(new Date().getTime()).toString();
             File f = new File("tts" + ".mp3");
             f.createNewFile();
             OutputStream outputStream = new FileOutputStream(f);
             while ((read =is.read(bytes)) != -1) {
                 outputStream.write(bytes, 0, read);
             }
             is.close();       
//
             
          // 서버소켓 객체 생성. 
             ServerSocket serverSocket = new ServerSocket(7777);   
             System.out.println("Start Server !");
             while(true)
             {
                 
             //-->접속 대기  
                Socket socket = serverSocket.accept();
                System.out.println("Connected Success");
             //<--
                
                OutputStream out = socket.getOutputStream();    // 파일출력(Out)을 위하여 어디로 out해야하는지 접속한 socket에 대한정보를 out에게 전달.    
                Scanner  scanner = new Scanner(socket.getInputStream());     // getInputStream()을 통하여 입력받은 값을 Scanner로 변경 -> 최종적으론 String으로 변환하기위하여.
                
                String str = scanner.nextLine(); // Scanner값을 String으로 변환.
                System.out.println(str);         //    str 값 -> "GET /aaa.mp3 HTTP/1.1"
                
                String [] arr=str.split(" ");    // 공백문자 제거 -> GET 과 / 사이에 공백 과 .mp3와 HTTP사이에 공백을 제거하기 위하여.
                System.out.println(arr[1]);      // arr[1]의 값 -> /aaa.mp3
                
                str = arr[1].substring(1);       // substirng(숫자) -> 0부터 시작하여 숫자 이하의 값만 출력하기위하여   
                System.out.println(str);         // str의 값-> "aaa.mp3"                    
                
                
              //-->Start_파일 경로 찾아오기.
                String fileName="C:\\study_boot\\trans//"+"tts"+".mp3";
                System.out.println(fileName);
                File file = new File(fileName);    // 파일의 정보를 가져오기 위한 File클래스 
                FileInputStream fin=new FileInputStream(file);
        
                String suffix= arr[1].substring(arr[1].lastIndexOf(".")+1); // arr[1] -> /aaa.mp3 가 있다. 
                System.out.println(suffix);                                 // lastIndexOf -> 문자열 검색 +1을 해줌으로써 "mp3"만 추출 
              //<--End_파일 경로 찾아오기.
                
              //-->Start_웹으로 파일 Out을위한 양식서 
                out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());           // 정상적으로온거임
                out.write(new String("Cache-Control: private\r\n").getBytes());  
                out.write(new String("Content-Length: "+file.length()+"\r\n").getBytes()); // 파일에대한 길이정보를 입력해주어야한다.
              //<--End_웹으로 파일 Out을위한 양식서
                
              //-->S_확장자에 따른 조건부  
                if(suffix.equals("mp3"))
                {
                   out.write(new String("Content-Type: audio/mpeg; charset=UTF-8\r\n\r\n").getBytes());
                }
                
                else if(suffix.equals("html"))
                {
                   out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());
                }
              //-->E_확장자에 따른 조건부
                
              //-->S_웹으로 파일 OutStream         
                byte [] buffer=new byte[1024*8];
        
                while(true)
                {
                   try
                   {
                      int cnt= fin.read(buffer);
            
                      if(cnt==-1)
                      {
                         break;
                      }
                      out.write(buffer, 0 , cnt);
        
                      //System.out.println(total);
                   } 
        
                   catch (Exception e) 
                   {
                   }
        
                }//end while
              //<--E_웹으로 파일 OutStream
                
                System.out.println("complete!!");
                fin.close();
                out.close();
                socket.close();
             }//end while 
             
//             
             
         } else {  // 오류 발생
             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
             String inputLine;
             StringBuffer response = new StringBuffer();
             while ((inputLine = br.readLine()) != null) {
                 response.append(inputLine);
             }
             br.close();
             System.out.println(response.toString());
         }
     } catch (Exception e) {
         System.out.println(e);
     }

  }
}

