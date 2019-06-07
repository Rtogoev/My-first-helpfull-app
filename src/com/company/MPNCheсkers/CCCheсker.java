package com.company.MPNCheсkers;

import com.company.Abstract.FILEChecker;

import java.util.ArrayList;

public class CCCheсker extends FILEChecker implements Runnable {
    public CCCheсker(ArrayList<String> logs) {
        super(logs);
    }

    @Override
    public void run() {

    /***    listOfErrors.add("BOX_REMOVED");
        listOfErrors.add("RECOVERY_MODE");
        listOfErrors.add("BOX_FULL");
        listOfErrors.add("BOX_ERROR");
        listOfErrors.add("BILL_JAMMED");
        listOfErrors.add("ERR_WR_REPOSITORY");
        listOfErrors.add("SECURITY_ERROR");
        listOfErrors.add("CRITICAL_ERROR");
        listOfErrors.add("GLOBAL_ERROR");
        listOfErrors.add("UPPER_OPTICAL_BOARD_NO_COMMUNICATION_ERROR");
        listOfErrors.add("UPPER_OPTICAL_BOARD_INTERNAL_ERROR");
        listOfErrors.add("UPPER_OPTICAL_BOARD_CAL_ERROR");
        listOfErrors.add("LOWER_OPTICAL_BOARD_NO_COMMUNICATION_ERROR");
        listOfErrors.add("LOWER_OPTICAL_BOARD_INTERNAL_ERROR");
        listOfErrors.add("LOWER_OPTICAL_BOARD_CAL_ERROR");
        listOfErrors.add("ERR_WR_BANK0");
        listOfErrors.add("UPPER_SENSOR_BOARD_NO_COMMUNICATION_ERROR");
        listOfErrors.add("UPPER_SENSOR_BOARD_INTERNAL_ERROR");
        listOfErrors.add("UPPER_SENSOR_BOARD_CAР_ERROR");
        listOfErrors.add("UPPER_SENSOR_BOARD_BAR_ERROR");
        listOfErrors.add("UPPER_SENSOR_BOARD_UV_ERROR");
        listOfErrors.add("UPPER_SENSOR_BOARD_STK_ERROR");
        listOfErrors.add("LOWER_SENSOR_BOARD_NO_COMMUNICATION_ERROR");
        listOfErrors.add("LOWER_SENSOR_BOARD_INTERNAL_ERROR");
        listOfErrors.add("LOWER_SENSOR_BOARD_CAР_ERROR");
        listOfErrors.add("ERR_RD_BANK0");
        listOfErrors.add("LOWER_SENSOR_BOARD_MAG_ERROR");
        listOfErrors.add("LOWER_SENSOR_BOARD_PASS_ERROR");
        listOfErrors.add("FRONT_LID_OPENED_ERROR");
        listOfErrors.add("REAR_LID_OPENED_ERROR");
        listOfErrors.add("USB_FLASH_ERROR");
        listOfErrors.add("UPPER_SENSOR_BOARD_CAL_ERROR");
        listOfErrors.add("LOWER_SENSOR_BOARD_CAL_ERROR");


        listOfOutputs.add("	Определено отсутствие съёмной кассеты купюроприемника	Правильно установить кассету в купюроприемник	");
        listOfOutputs.add("	Ошибка исправности рабочей прошивки купюроприемника. Прием купюр невозможен, но возможно обновление прошивки.	Обновить прошивку купюроприемника через USB-флеш накопитель или через интерфейс CCNET	");
        listOfOutputs.add("	Кассета наполнена купюрами до предела	Изъять купюры из кассеты	");
        listOfOutputs.add("	Ошибка функционирования кассеты (например, заклинивание платформы укладчика)	Проверить кассету на отсутствие посторонних предметов, замятий купюр, заклиниваний функциональных элементов	");
        listOfOutputs.add("	Заклинивание купюры в тракте купюроприемника	Удалить посторонние предметы из тракта, проверить отсутствие загрязнений сенсоров. Провести калибровку оптики	");
        listOfOutputs.add("	Ошибка загрузчика (бута). Невозможно записать данные в репозиторий (ЕММС)	Обратиться в сервис центр	");
        listOfOutputs.add("	Ошибка контроля политики обновлений прошивок (например, контроля лицензий).	Обновить прошивку купюроприемника через USB-флеш накопитель или через интерфейс CCNET 	");
        listOfOutputs.add("	Ошибка ПЗУ купюроприемника. Прием купюр невозможен, но возможно обновление прошивки 	Обновить прошивку купюроприемника через USB-флеш накопитель или через интерфейс CCNET	");
        listOfOutputs.add("	Сбой в работе прошивки купюроприемника. Неисправность периферийной платы датчиков	Выполнить аппаратный сброс купюроприемника «передергиванием» питания. 	");
        listOfOutputs.add("	Нет связи с верхней периферийной платы оптических датчиков (SB31.25)	Проверить исправность цепей связи, разъёмов подключения верхней периферийной платы оптических датчиков к главной плате	");
        listOfOutputs.add("	Ошибка исправности прошивки верхней периферийной платы оптических датчиков (SB31.25)	Заменить верхнюю периферийную плату оптических датчиков, выполнить калибровку оптики купюроприемника 	");
        listOfOutputs.add("	Ошибка исправности калибровочных данных верхней периферийной платы оптических датчиков (SB31.25)	Выполнить калибровку оптики купюроприемника в условиях сервисного центра	");
        listOfOutputs.add("	Нет связи с нижней периферийной платой оптических датчиков (SB31.25)	Проверить исправность цепей связи, разъёмов подключения нижней периферийной платы оптических датчиков к главной плате	");
        listOfOutputs.add("	Ошибка исправности прошивки нижней периферийной платы оптических датчиков (SB31.25)	Заменить нижнюю периферийную плату оптических датчиков, выполнить калибровку купюроприемника в условиях сервисного центра	");
        listOfOutputs.add("	Ошибка исправности калибровочных данных нижней периферийной платы оптических датчиков (SB31.25)	Выполнить калибровку купюроприемника в условиях сервисного центра	");
        listOfOutputs.add("	Ошибка загрузчика (бута). 	Обратиться в сервис центр	");
        listOfOutputs.add("	Нет связи с верхней периферийной платой функциональных датчиков (МХ01.53)	Проверить исправность цепей связи, разъёмов подключения верхней периферийной платы функциональных датчиков к главной плате	");
        listOfOutputs.add("	Ошибка исправности прошивки верхней периферийной платы функциональных датчиков (МХ01.53)	Заменить периферийную плату МХ01.53, выполнить калибровку купюроприемника в условиях сервисного центра	");
        listOfOutputs.add("	Ошибка датчика диэлектрической проницаемости верхней периферийной платы функциональных датчиков (МХ01.53)	Проверить отсутствие загрязнений датчика, посторонних предметов. Заменить плату в условиях сервисного центра	");
        listOfOutputs.add("	Ошибка датчика баркода верхней периферийной платы функциональных датчиков (МХ01.53)	Проверить отсутствие загрязнений датчика, посторонних предметов. Заменить плату в условиях сервисного центра	");
        listOfOutputs.add("	Ошибка датчика ультрафиолета верхней периферийной платы функциональных датчиков (МХ01.53)	Проверить отсутствие загрязнений датчика, посторонних предметов. Заменить плату в условиях сервисного центра	");
        listOfOutputs.add("	Ошибка датчика антистокса верхней периферийной платы функциональных датчиков (МХ01.53)	Проверить отсутствие загрязнений датчика, посторонних предметов. Заменить плату в условиях сервисного центра	");
        listOfOutputs.add("	Нет связи с нижней периферийной платой функциональных датчиков (МХ01.52)	Проверить исправность цепей связи, разъёмов подключения нижней периферийной платы функциональных датчиков к главной плате	");
        listOfOutputs.add("	Ошибка исправности прошивки нижней периферийной платы функциональных датчиков (МХ01.52)	Заменить нижнюю периферийную плату МХ01.52, выполнить калибровку купюроприемника в условиях сервисного центра	");
        listOfOutputs.add("	Ошибка датчика диэлектрической проницаемости нижней периферийной платы функциональных датчиков (МХ01.52)	Проверить отсутствие загрязнений датчика, посторонних предметов. Заменить плату в условиях сервисного центра	");
        listOfOutputs.add("	Ошибка загрузчика (бута). 	Обратиться в сервис центр	");
        listOfOutputs.add("	Ошибка индуктивного датчика нижней периферийной платы функциональных датчиков (МХ01.52)	Проверить отсутствие загрязнений датчика, посторонних предметов. Заменить плату в условиях сервисного центра	");
        listOfOutputs.add("	Ошибка датчика “Pass Sensor” нижней периферийной платы функциональных датчиков (МХ01.52)	Проверить отсутствие загрязнений датчика, посторонних предметов. Заменить плату в условиях сервисного центра	");
        listOfOutputs.add("	Открыта передняя откидная крышка тракта	Закрыть крышку	");
        listOfOutputs.add("	Открыта задняя откидная крышка тракта	Закрыть крышку	");
        listOfOutputs.add("	Ошибка USB флеш накопителя (например, недостаточно свободной памяти)	Заменить USB флеш накопитель	");
        listOfOutputs.add("	Ошибка исправности калибровочных данных верхней периферийной платы функциональных датчиков (МХ01.53)	Выполнить калибровку купюроприемника в условиях сервисного центра	");
        listOfOutputs.add("	Ошибка исправности калибровочных данных нижней периферийной платы функциональных датчиков (МХ01.52)	Выполнить калибровку купюроприемника в условиях сервисного центра	");
*/

/**

 OPTICAL FAILURE                
 MAGNETIC FAILURE                
 BOX FAILURE                       
 DIELECTRIC FAILURE                
 LID OPEN                         
 INTEGRITY ERROR                   
 CALIBRATION FAILURE              
 BOOT OPERATION ERROR             
 OPTICAL TOP FAILURE
 OPTICAL BOTTOM FAILURE
 SECONDARY SENSOR BORD TOP FAILURE
 SECONDARY SENSOR BORD BOTTOM FAILURE
 */

        openFilesCountErrorsPrintOutputs();

    }

    @Override
    public void defineErrorsAndOutputs(ArrayList<String> listOfErrors, ArrayList<String> listOfOutputs) {
        listOfErrors.add("Transport_Motor_Failure");
        listOfErrors.add("Drop_Cassette_out_of_position");
        listOfErrors.add("Drop_Cassette_Full");
        listOfErrors.add("Drop_Cassette_Jammed");
        listOfErrors.add("Validator_Jammed");
        listOfErrors.add("Aligning_Motor_Failure");
        listOfErrors.add("Stack_Motor_Failure");
        listOfErrors.add("Transport_Motor_Speed_Failure");
        listOfErrors.add("Magnetic_Canal_Failure");
        listOfErrors.add("Optic_Canal_Failure");
        listOfErrors.add("Initial_Cassette_Status_Failure");
        listOfErrors.add("Capacitance_Canal_Failure");
        listOfErrors.add("Power_Up_with_Bill_in_Validator");
        listOfOutputs.add("Transport_Motor_Failure");


        listOfOutputs.add("Drop_Cassette_out_of_position");
        listOfOutputs.add("Drop_Cassette_Full");
        listOfOutputs.add("Drop_Cassette_Jammed");
        listOfOutputs.add("Validator_Jammed");
        listOfOutputs.add("Aligning_Motor_Failure");
        listOfOutputs.add("Stack_Motor_Failure");
        listOfOutputs.add("Transport_Motor_Speed_Failure");
        listOfOutputs.add("Magnetic_Canal_Failure");
        listOfOutputs.add("Optic_Canal_Failure");
        listOfOutputs.add("Initial_Cassette_Status_Failure");
        listOfOutputs.add("Capacitance_Canal_Failure");
        listOfOutputs.add("Power_Up_with_Bill_in_Validator");
        super.defineErrorsAndOutputs(listOfErrors, listOfOutputs);
    }
}
