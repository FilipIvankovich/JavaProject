package hr.tvz.ivankovic.hardwareapp;

import hr.tvz.ivankovic.hardwareapp.hardware.Hardware;
import hr.tvz.ivankovic.hardwareapp.hardware.HardwareDTO;
import hr.tvz.ivankovic.hardwareapp.hardware.HardwareServiceImpl;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDate;
import java.util.List;

public class HardwareJob extends QuartzJobBean {

    @Autowired
    private HardwareServiceImpl hardwareService;

    public void setHardwareService(HardwareServiceImpl hardwareService){
        this.hardwareService = hardwareService;
    }

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        List<HardwareDTO> hardwareList = hardwareService.findAll();
        System.out.println("Ovo su trenutno dostupni hardveri");
        System.out.println("---------------------------------");

        for(int i=0; i < hardwareService.findAll().size(); i++)
            if(hardwareList.get(i).getAvailability() != 0)
                System.out.printf("%s - %d\n", hardwareList.get(i).getName(), hardwareList.get(i).getAvailability());
        System.out.println("---------------------------------");
    }
}

