package io.matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NNRequest {

    public void login(String name, String pwd){
        final String url = "http://www.niuniuzai.com/user/account/login";
        final Map<String, String> datas = new HashMap<>();
        datas.put("csrf_doniuren", "e5fdd0371f339263977c725cab684cdd");
        datas.put("account", name);
        datas.put("password", pwd);


    }
}
