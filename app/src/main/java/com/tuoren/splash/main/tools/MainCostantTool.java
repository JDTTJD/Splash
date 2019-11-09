package com.tuoren.splash.main.tools;

import androidx.annotation.IntDef;

import static com.tuoren.splash.main.tools.MainCostantTool.BEIJING;
import static com.tuoren.splash.main.tools.MainCostantTool.HANGZHOU;
import static com.tuoren.splash.main.tools.MainCostantTool.SHANGHAI;
import static com.tuoren.splash.main.tools.MainCostantTool.SHENZHEN;

/**
 * Create by JDT on 2019/11/9.
 */
@IntDef({SHANGHAI,HANGZHOU,BEIJING,SHENZHEN})
public @interface MainCostantTool {
    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;
}
