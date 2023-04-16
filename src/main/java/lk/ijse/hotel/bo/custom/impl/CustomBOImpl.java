package lk.ijse.hotel.bo.custom.impl;

import lk.ijse.hotel.bo.custom.CustomBO;
import lk.ijse.hotel.bo.util.FactoryConfiguration;
import lk.ijse.hotel.dao.DAOFactory;
import lk.ijse.hotel.dao.DAOType;
import lk.ijse.hotel.dao.custom.CustomDAO;
import lk.ijse.hotel.dao.custom.impl.CustomDAOImpl;
import lk.ijse.hotel.dto.CustomDTO;
import lk.ijse.hotel.entity.Custom;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class CustomBOImpl implements CustomBO {

    CustomDAO customDAO= (CustomDAOImpl) DAOFactory.getInstance().getDAO(DAOType.CUSTOM);
    @Override
    public List<CustomDTO> getAllReservationDetails() {
        final List<Custom> details = customDAO.getAllReservationDetails(FactoryConfiguration.getInstance().getSession());
        return new ModelMapper().map(details,new TypeToken<List<CustomDTO>>(){}.getType());
    }

    @Override
    public void openSession() {

    }

    @Override
    public void closeSession() {

    }
}
