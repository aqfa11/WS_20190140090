/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamahasiswa.penilaian;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.persistence.internal.oxm.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author MSI NOTEBOOK
 */
@Controller
public class databasemahasiswaController {
    
    @RequestMapping("/mahasiswa")
    @ResponseBody
    public List<Mahasiswaumy> getMahasiswa() {

        List<Mahasiswaumy> mahasiswa = new ArrayList<>();
        
        MahasiswaumyJpaController controller = new MahasiswaumyJpaController();
        
       try {
            mahasiswa = controller.findMahasiswaumyEntities();            
        } catch (Exception e) {
            System.out.println(e);
        }
               
        return mahasiswa;
    }
    
    @RequestMapping(value = "/mahasiswa/xml",
            produces = {org.springframework.http.MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Mahasiswaumy> getMahasiswaXML() {

        List<Mahasiswaumy> mahasiswa = new ArrayList<>();
        
        MahasiswaumyJpaController controller = new MahasiswaumyJpaController();
        
       try {
            mahasiswa = controller.findMahasiswaumyEntities();            
        } catch (Exception e) {
            System.out.println(e);
        }
           
    
        return mahasiswa;
    }   
    
    @RequestMapping(value = "/mahasiswa/json",
            produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Mahasiswaumy> getMahasiswaJSON() {

        List<Mahasiswaumy> mahasiswa = new ArrayList<>();
        
        MahasiswaumyJpaController controller = new MahasiswaumyJpaController();
        
       try {
            mahasiswa = controller.findMahasiswaumyEntities();            
        } catch (Exception e) {
            System.out.println(e);
        }
           
       return mahasiswa;
    }
}
