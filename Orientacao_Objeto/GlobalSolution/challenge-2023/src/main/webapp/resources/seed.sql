INSERT INTO EXAMS_TYPE (NAME_EXAM) VALUES (
    'Oftalmologia'
);

INSERT INTO EXAMS_TYPE (NAME_EXAM) VALUES (
    'Dermatologia'
);

INSERT INTO EXAMS_TYPE (NAME_EXAM) VALUES (
    'Ortopedista'
);

INSERT INTO APPOINTMENT_EXAMS (NAME_APPOINT, TYPE_EXAM) VALUES (
    'Exame de Refração',
    1
);

INSERT INTO APPOINTMENT_EXAMS (NAME_APPOINT, TYPE_EXAM) VALUES (
    'Mapeamento de retina',
    1
);

INSERT INTO APPOINTMENT_EXAMS (NAME_APPOINT, TYPE_EXAM) VALUES (
    'Luz de Wood',
    2
);

INSERT INTO APPOINTMENT_EXAMS (NAME_APPOINT, TYPE_EXAM) VALUES (
    'Biópsia Endoscópica',
    2
);

INSERT INTO APPOINTMENT_EXAMS (NAME_APPOINT, TYPE_EXAM) VALUES (
    'Raio-X',
    3
);

INSERT INTO APPOINTMENT_EXAMS (NAME_APPOINT, TYPE_EXAM) VALUES (
    'Ultrassom',
    3
);

INSERT INTO TECHNOLOGIES (NAME, DESCRIPTION, EXAM_TYPE) VALUES (
    'Refrator Computadorizado',
    'Aparelho composto por um conjunto de lentes corretivas usado para encontrar
    o grau de refração com o qual o paciente informa ter uma melhor acuidade visual.',
    1
);

INSERT INTO TECHNOLOGIES (NAME, DESCRIPTION, EXAM_TYPE) VALUES (
    'Oftalmoloscópio',
    'Serve para uma boa observação do fundo do olho do paciente, de uma maneira direta
    e precisa, quando o meio estiver transparente.',
    1
);

INSERT INTO TECHNOLOGIES (NAME, DESCRIPTION, EXAM_TYPE) VALUES (
    'Luz de Wood',
    'Verifica a presença de lesões na pele, suas caracterísitcas e extensão de com a fluorescência
    observada quando a lesão analisada é exposta à luz UV.',
    2
);

INSERT INTO TECHNOLOGIES (NAME, DESCRIPTION, EXAM_TYPE) VALUES (
    'Biópsia com endoscópio',
    'Por meio do endoscópio, um tubo fino que tem um microcâmera em sua extremidade,
    ele permite visualizar as paredes do esôfago, estômago e duodeno.',
    2
);

INSERT INTO TECHNOLOGIES (NAME, DESCRIPTION, EXAM_TYPE) VALUES (
    'Espessômetro',
    'É responsável por ajustar a intensidade dos raios, o espessômetro quantifica a exposição à
    radiação. Assim, faz a análise de características como altura, peso e envergadura dos pacientes na realização do
    exame.',
    3
);

INSERT INTO TECHNOLOGIES (NAME, DESCRIPTION, EXAM_TYPE) VALUES (
    'Transdutor convexo(curvo)',
    'Utilização é feita de forma externa, ou seja, por sobre a pele, e produz uma
    imagem triangular no visor do equipamento de ultrassom. Principal para órgãos abdominais até ovários.',
    3
);

COMMIT;