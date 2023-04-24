package cybersoft.java20.dev3lopers.gear3sproject.service.imp;

import cybersoft.java20.dev3lopers.gear3sproject.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    boolean checkLogin(String email, String password);
    boolean checkEmailExistence(String email);

    boolean createUser(AccountDTO accountDTO,boolean byAdmin);
    List<AdUserDTO> readAllUser();
    UserDTO readUserByIdByUser(int userId);
    AdUserDTO readUserByIdByAdmin(int userId);
    boolean updateUserByUser(UserDTO userDTO, MultipartFile avatarFile);
    boolean updateUserPassword(int userId, PasswordDTO passwordDTO);
    boolean updateUserRoleByAdmin(int userId, int roleId);
    boolean deleteUser(int id);
    boolean updateLastPay(int userId, int userCardId);


}
