CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    salary DECIMAL(15,2),
    departament VARCHAR(255),
    address VARCHAR(255),
    phoneNo VARCHAR(255)
);

-- NOVO PROJETO JSP
CREATE TABLE departamento (
    IdeDep INTEGER NOT NULL AUTO_INCREMENT,
    NomDep VARCHAR(50) NULL,
    TelDep VARCHAR(15) NULL,
    PRIMARY KEY (IdeDep)
);

CREATE TABLE funcionario (
    IdeFun INTEGER NOT NULL AUTO_INCREMENT,
    IdeDep INTEGER NOT NULL,
    NomFun VARCHAR(50) NULL,
    TelFun VARCHAR(15) NULL,
    CarFun VARCHAR(30) NULL,
    SalFun DECIMAL(15,2) NULL,
    PRIMARY KEY(IdeFun),
    FOREIGN KEY(IdeDep)
        REFERENCES departamento(IdeDep)
            ON DELETE CASCADE
            ON UPDATE NO ACTION
);