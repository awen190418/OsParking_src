/* 
 * Copyright (C) 2015, 2016  Open Source Parking, Inc.(www.osparking.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.osparking.global.names;

import static com.osparking.global.names.ControlEnums.DialogMessages.PW_COMPLEX_DIALOG;
import static com.osparking.global.names.ControlEnums.DialogMessages.PW_FOURDIGIT_DIALOG;
import static com.osparking.global.names.ControlEnums.DialogMessages.PW_SIXDIGIT_DIALOG;
import static com.osparking.global.names.ControlEnums.LabelContent.HOWTO_CHANGE_PW_STRENGTH;
import static com.osparking.global.names.ControlEnums.LabelContent.PASSWORD_LEVEL_LABEL;
import static com.osparking.global.names.ControlEnums.MenuITemTypes.SETTING_MENU_ITEM;
import static com.osparking.global.names.ControlEnums.MenuITemTypes.SYSTEM_MENU;
import static com.osparking.global.names.ControlEnums.ToolTipContent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.osparking.global.names.DB_Access.pwStrengthLevel;
import com.osparking.global.names.OSP_enums.PWStrengthLevel;
import org.jsoup.Jsoup;

public class PasswordValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String PW_PATTERN_4DIGITS = "((?=\\d{4}).{4,4})";
    private static final String PW_PATTERN_6ALNUM = "((?=.*[a-zA-Z])(?=.*\\d).{6,40})";
        // one Upper, one Lower, one digit, one special char, 
    private static final String PW_PATTERN_COMPLEX = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[!@#$%&*()]).{8,40})";

    public PasswordValidator() {
        if (pwStrengthLevel == PWStrengthLevel.FourDigit.ordinal()) 
        {
            pattern = Pattern.compile(PW_PATTERN_4DIGITS);
        } else if (pwStrengthLevel == PWStrengthLevel.SixDigit.ordinal()) 
        {
            pattern = Pattern.compile(PW_PATTERN_6ALNUM);
        } else 
        {
            pattern = Pattern.compile(PW_PATTERN_COMPLEX);
        }
    }

    public boolean isInValidForm(final String password) {
            matcher = pattern.matcher(password);
            return matcher.matches();
    }
    
    public String getPasswordTooltip() 
    {
        if (pwStrengthLevel == PWStrengthLevel.FourDigit.ordinal()) 
        {
            return PW_FOURDIGIT_TOOLTIP.getContent();
        } 
        else if (pwStrengthLevel == PWStrengthLevel.SixDigit.ordinal()) 
        {
            return PW_SIXDIGIT_TOOLTIP.getContent();
        } 
        else 
        {
            return PW_COMPLEX_TOOLTIP.getContent();
        }   
    }
    
    
    public String getWrongPWFormatMsg(short level) 
    {
        if (level == PWStrengthLevel.FourDigit.ordinal()) 
        {
            return getTextFor(ControlEnums.DialogMessages.PW_FOURDIGIT_DIALOG);
        } 
        else if (level == PWStrengthLevel.SixDigit.ordinal()) 
        {
            return getTextFor(ControlEnums.DialogMessages.PW_SIXDIGIT_DIALOG);
        } 
        else 
        {
            return getTextFor(ControlEnums.DialogMessages.PW_COMPLEX_DIALOG);
        }   
    }
    
    
    private String getTextFor(ControlEnums.DialogMessages msgType){
        StringBuilder sBuilder = new StringBuilder();
        
        switch (msgType) {
            case PW_FOURDIGIT_DIALOG:
                sBuilder.append(PW_FOURDIGIT_DIALOG.getContent());
                sBuilder.append("\n\n");
                sBuilder.append("(예) 0123");
                break;
            
            case PW_SIXDIGIT_DIALOG:
                sBuilder.append(PW_SIXDIGIT_DIALOG.getContent());
                sBuilder.append("\n\n");
                sBuilder.append("(e.g., pti34z)");
                break;
            
            case PW_COMPLEX_DIALOG:
                sBuilder.append(PW_COMPLEX_DIALOG.getContent());
                sBuilder.append("\n     !  @  #  $  %  &  *  (  )\n");
                sBuilder.append("\n");
                sBuilder.append("(e.g., abM56!xy)");
                break;
        default:
            break;
        }

        return sBuilder.toString();
    }
}
