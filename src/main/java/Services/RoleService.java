package Services;

import Exception.ExceptionCustom;
import Factory.RoleFactory;
import Models.ConnectionBD;
import Models.Role;
import Repositories.RoleRepository;
import Services.Interfaces.RoleServiceInterface;

/**
 * The type Role service.
 */
public class RoleService implements RoleServiceInterface {
    private static final RoleService instance = new RoleService();
    private RoleRepository roleRepository = RoleRepository.GetInstance();
    private RoleFactory roleFactory = RoleFactory.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();
    private Object connection = this.connectionBD.GetConnectionStatus();
    private VerificationService verificationService = VerificationService.GetInstance();

    /**
     * Get instance role service.
     *
     * @return the role service
     */
    public static RoleService GetInstance() {
        return instance;
    }

    @Override
    public Role FindById(int id) throws Exception {
        boolean valide = this.verificationService.verifier(id);
        Role ret = null;

        if (valide) {
            if (connection == null) {
                try {
                    ret = this.roleRepository.FindById(id);
                } catch (Exception e) {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        } else {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }
        return ret;
    }

    @Override
    public void Update(Role roleToUpdate) throws Exception {
        boolean valide = this.verificationService.verifier(roleToUpdate.getIdRole());
        if (valide) {
            valide = this.verificationService.verifier(roleToUpdate.getRoleName());
        }

        if (valide) {
            if (connection == null) {
                try {
                    this.roleRepository.Update(roleToUpdate);
                } catch (Exception e) {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        } else {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }
    }

    @Override
    public void Delete(int id) throws Exception {
        boolean valide = this.verificationService.verifier(id);
        if (valide) {
            if (connection == null) {
                try {
                    this.roleRepository.Delete(id);
                } catch (Exception e) {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        } else {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }
    }

    @Override
    public Role Create(String permission, String roleName) throws Exception {
        boolean valide = this.verificationService.verifierPermission(permission);
        Role createdRole;
        if (valide) {
            valide = this.verificationService.verifier(roleName);
        }

        if (valide) {
            if (connection == null) {
                try {
                    Role roleToCreate = roleFactory.Create(0, permission, roleName);
                    createdRole = this.roleRepository.Create(roleToCreate);
                } catch (Exception e) {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd" + e.toString());
                    throw exceptionErreurBD;
                }
            } else {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                throw exceptionErreurBD;
            }
        } else {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }
        return createdRole;
    }
}
