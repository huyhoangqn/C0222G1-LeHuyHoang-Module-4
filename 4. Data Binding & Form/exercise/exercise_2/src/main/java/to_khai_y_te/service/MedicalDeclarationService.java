package to_khai_y_te.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("Medical")
public class MedicalDeclarationService implements IMedicalDeclarationService {
    @Override
    public List<String> genders() {
        List<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        genders.add("Other");
        return genders;
    }

    @Override
    public List<String> nationalitys() {
        List<String> nationalitys = new ArrayList<>();
        nationalitys.add("VietNam");
        nationalitys.add("Laos");
        nationalitys.add("American");
        nationalitys.add("Korea");
        return nationalitys;
    }

    @Override
    public List<String> years() {
        List<String> years = new ArrayList<>();
        years.add("1997");
        years.add("1998");
        years.add("1999");
        years.add("2000");
        return years;
    }

    @Override
    public List<String> vehicles() {
        List<String> vehicles = new ArrayList<>();
        vehicles.add("Tàu bay");
        vehicles.add("Tàu thuyền");
        vehicles.add("Ô tô");
        vehicles.add("Khác");
        return vehicles;
    }
}
