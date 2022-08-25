package com.klemstinegroup;

import com.igormaznitsa.jjjvm.impl.JJJVMClassImpl;
import com.igormaznitsa.jjjvm.impl.jse.JSEProviderImpl;
import com.igormaznitsa.jjjvm.model.JJJVMClass;
import com.igormaznitsa.jjjvm.model.JJJVMProvider;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.engine.Engine;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.util.List;

public class DominionMain {

    public static void main(String[] args){
       new DominionMain();
    }

    public DominionMain(){
/*
       OpenAiService service = new OpenAiService("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");
//        Engine engine = service.getEngine("code-davinci-002");
//        System.out.println(engine);

        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("create a Java sort algorithm").echo(true)
                .maxTokens(204)
                .build();
        List<CompletionChoice> choices = service.createCompletion("code-davinci-002", completionRequest).getChoices();
        for (CompletionChoice cc:choices){
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println(cc.getText());
        }
*/

        JFrame frame = new JFrame("Dominion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

//        JPanel title = new JPanel();
//
//        JLabel header = new JLabel("<html><span style='color: teal;'>Dominion</span></html>");
//        header.setFont(header.getFont().deriveFont(64.0F));
//
//        title.add(header);
//
//        mainPanel.add(title);
//        mainPanel.add(Box.createVerticalStrut(10));

//        JPanel info = new JPanel();
//        info.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 10));
//
//        JLabel version = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Version 1.0<br>Created by Luke Carr</html>");
//        info.add(version);
//
//        JLabel slogan = new JLabel("<html>Full Potential<br>Minimal Knowledge</html>");
//        info.add(slogan);
//
//        mainPanel.add(info);
        mainPanel.add(Box.createVerticalStrut(20));

        JPanel codePanel = new JPanel();

        JTextArea code = new JTextArea(5, 45);
        codePanel.add(code);

        mainPanel.add(codePanel);

        JPanel outputPanel = new JPanel();

        JTextArea output= new JTextArea(25, 45);
        MessageConsole mc=new MessageConsole(output,true);

        mc.redirectOut();
        mc.redirectErr();
        outputPanel.add(output);

        mainPanel.add(outputPanel);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        mc.setMessageLines(output.getRows());

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    System.out.println(i);

                    JJJVMProvider provider = new JSEProviderImpl(){
                        @Override
                        public Object invoke(JJJVMClass caller, Object instance, String jvmFormattedClassName, String methodName, String methodSignature, Object[] arguments) throws Throwable {
                            if (jvmFormattedClassName.equals("java/io/PrintStream") && methodName.equals("println") && methodSignature.equals("(Ljava/lang/String;)V")){
//                                Gdx.app.log("out","<<"+arguments[0]+">>");
                                System.out.println(arguments[0]);
                                return null;
                            }
                            return super.invoke(caller, instance, jvmFormattedClassName, methodName, methodSignature, arguments); //To change body of generated methods, choose Tools | Templates.
                        }
                    };
                    JJJVMClassImpl jjjvmClass = null;
                    try {
                        byte[] b=new byte[]{-54, -2, -70, -66, 0, 0, 0, 52, 0, 34, 10, 0, 6, 0, 20, 9, 0, 21, 0, 22, 8, 0, 23, 10, 0, 24, 0, 25, 7, 0, 26, 7, 0, 27, 1, 0, 6, 60, 105, 110, 105, 116, 62, 1, 0, 3, 40, 41, 86, 1, 0, 4, 67, 111, 100, 101, 1, 0, 15, 76, 105, 110, 101, 78, 117, 109, 98, 101, 114, 84, 97, 98, 108, 101, 1, 0, 18, 76, 111, 99, 97, 108, 86, 97, 114, 105, 97, 98, 108, 101, 84, 97, 98, 108, 101, 1, 0, 4, 116, 104, 105, 115, 1, 0, 43, 76, 99, 111, 109, 47, 107, 108, 101, 109, 115, 116, 105, 110, 101, 103, 114, 111, 117, 112, 47, 115, 117, 110, 115, 104, 105, 110, 101, 108, 97, 98, 47, 72, 101, 108, 108, 111, 87, 111, 114, 108, 100, 59, 1, 0, 4, 109, 97, 105, 110, 1, 0, 22, 40, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 41, 86, 1, 0, 4, 97, 114, 103, 115, 1, 0, 19, 91, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 1, 0, 10, 83, 111, 117, 114, 99, 101, 70, 105, 108, 101, 1, 0, 15, 72, 101, 108, 108, 111, 87, 111, 114, 108, 100, 46, 106, 97, 118, 97, 12, 0, 7, 0, 8, 7, 0, 28, 12, 0, 29, 0, 30, 1, 0, 12, 72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33, 7, 0, 31, 12, 0, 32, 0, 33, 1, 0, 41, 99, 111, 109, 47, 107, 108, 101, 109, 115, 116, 105, 110, 101, 103, 114, 111, 117, 112, 47, 115, 117, 110, 115, 104, 105, 110, 101, 108, 97, 98, 47, 72, 101, 108, 108, 111, 87, 111, 114, 108, 100, 1, 0, 16, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 1, 0, 16, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 121, 115, 116, 101, 109, 1, 0, 3, 111, 117, 116, 1, 0, 21, 76, 106, 97, 118, 97, 47, 105, 111, 47, 80, 114, 105, 110, 116, 83, 116, 114, 101, 97, 109, 59, 1, 0, 19, 106, 97, 118, 97, 47, 105, 111, 47, 80, 114, 105, 110, 116, 83, 116, 114, 101, 97, 109, 1, 0, 7, 112, 114, 105, 110, 116, 108, 110, 1, 0, 21, 40, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 41, 86, 0, 33, 0, 5, 0, 6, 0, 0, 0, 0, 0, 2, 0, 1, 0, 7, 0, 8, 0, 1, 0, 9, 0, 0, 0, 47, 0, 1, 0, 1, 0, 0, 0, 5, 42, -73, 0, 1, -79, 0, 0, 0, 2, 0, 10, 0, 0, 0, 6, 0, 1, 0, 0, 0, 7, 0, 11, 0, 0, 0, 12, 0, 1, 0, 0, 0, 5, 0, 12, 0, 13, 0, 0, 0, -119, 0, 14, 0, 15, 0, 1, 0, 9, 0, 0, 0, 55, 0, 2, 0, 1, 0, 0, 0, 9, -78, 0, 2, 18, 3, -74, 0, 4, -79, 0, 0, 0, 2, 0, 10, 0, 0, 0, 10, 0, 2, 0, 0, 0, 9, 0, 8, 0, 11, 0, 11, 0, 0, 0, 12, 0, 1, 0, 0, 0, 9, 0, 16, 0, 17, 0, 0, 0, 1, 0, 18, 0, 0, 0, 2, 0, 19};
                        jjjvmClass = new JJJVMClassImpl(new ByteArrayInputStream(b), provider);
                        jjjvmClass.findMethod("main", "([Ljava/lang/String;)V").invoke(null, null);
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        }).start();
    }
}
