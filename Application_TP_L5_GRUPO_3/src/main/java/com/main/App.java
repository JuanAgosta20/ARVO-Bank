package com.main;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Model.Account;
import com.Model.Administrative;
import com.Model.City;
import com.Model.Client;
import com.Model.Connection;
import com.Model.Countrie;
import com.Model.FeePayment;
import com.Model.Genre;
import com.Model.Loan;
import com.Model.Province;
import com.Model.Transaction;
import com.Model.User;
import com.Model.typeAccount;
import com.Model.typeMove;
import com.Model.Cmd;

public class App {

	public static void main(String[] args) {

		SessionFactory sf = Connection.getInstance();
		try {
			Session session = sf.openSession();
			session.beginTransaction();

			// LOCACIONES
			Countrie countries[] = { Utilities.createCountrie("Afganistán"), // 0
					Utilities.createCountrie("Albania"), // 1
					Utilities.createCountrie("Alemania"), // 2
					Utilities.createCountrie("Algeria"), // 3
					Utilities.createCountrie("Andorra"), // 4
					Utilities.createCountrie("Angola"), // 5
					Utilities.createCountrie("Anguila"), // 6
					Utilities.createCountrie("Antártida"), // 7
					Utilities.createCountrie("Antigua y Barbuda"), // 8
					Utilities.createCountrie("Antillas Neerlandesas"), // 9
					Utilities.createCountrie("Arabia Saudita"), // 10
					Utilities.createCountrie("Argentina"), // 11
					Utilities.createCountrie("Armenia"), // 12
					Utilities.createCountrie("Aruba"), // 13
					Utilities.createCountrie("Australia"), // 14
					Utilities.createCountrie("Austria"), // 15
					Utilities.createCountrie("Azerbayán"), // 16
					Utilities.createCountrie("Bélgica"), // 17
					Utilities.createCountrie("Bahamas"), // 18
					Utilities.createCountrie("Bahrein"), // 19
					Utilities.createCountrie("Bangladesh"), // 20
					Utilities.createCountrie("Barbados"), // 21
					Utilities.createCountrie("Belice"), // 22
					Utilities.createCountrie("Benín"), // 23
					Utilities.createCountrie("Bhután"), // 24
					Utilities.createCountrie("Bielorrusia"), // 25
					Utilities.createCountrie("Birmania"), // 26
					Utilities.createCountrie("Bolivia"), // 27
					Utilities.createCountrie("Bosnia y Herzegovina"), // 28
					Utilities.createCountrie("Botsuana"), // 29
					Utilities.createCountrie("Brasil"), // 30
					Utilities.createCountrie("Brunéi"), // 31
					Utilities.createCountrie("Bulgaria"), // 32
					Utilities.createCountrie("Burkina Faso"), // 33
					Utilities.createCountrie("Burundi"), // 34
					Utilities.createCountrie("Cabo Verde"), // 35
					Utilities.createCountrie("Camboya"), // 36
					Utilities.createCountrie("Camerún"), // 37
					Utilities.createCountrie("Canadá"), // 38
					Utilities.createCountrie("Chad"), // 39
					Utilities.createCountrie("Chile"), // 40
					Utilities.createCountrie("China"), // 41
					Utilities.createCountrie("Chipre"), // 42
					Utilities.createCountrie("Ciudad del Vaticano"), // 43
					Utilities.createCountrie("Colombia"), // 44
					Utilities.createCountrie("Comoras"), // 45
					Utilities.createCountrie("Congo"), // 46
					Utilities.createCountrie("Congo"), // 47
					Utilities.createCountrie("Corea del Norte"), // 48
					Utilities.createCountrie("Corea del Sur"), // 49
					Utilities.createCountrie("Costa de Marfil"), // 50
					Utilities.createCountrie("Costa Rica"), // 51
					Utilities.createCountrie("Croacia"), // 52
					Utilities.createCountrie("Cuba"), // 53
					Utilities.createCountrie("Dinamarca"), // 54
					Utilities.createCountrie("Dominica"), // 55
					Utilities.createCountrie("Ecuador"), // 56
					Utilities.createCountrie("Egipto"), // 57
					Utilities.createCountrie("El Salvador"), // 58
					Utilities.createCountrie("Emiratos Árabes Unidos"), // 59
					Utilities.createCountrie("Eritrea"), // 60
					Utilities.createCountrie("Eslovaquia"), // 61
					Utilities.createCountrie("Eslovenia"), // 62
					Utilities.createCountrie("España"), // 63
					Utilities.createCountrie("Estados Unidos de América"), // 64
					Utilities.createCountrie("Estonia"), // 65
					Utilities.createCountrie("Etiopía"), // 66
					Utilities.createCountrie("Filipinas"), // 67
					Utilities.createCountrie("Finlandia"), // 68
					Utilities.createCountrie("Fiyi"), // 69
					Utilities.createCountrie("Francia"), // 70
					Utilities.createCountrie("Gabón"), // 71
					Utilities.createCountrie("Gambia"), // 72
					Utilities.createCountrie("Georgia"), // 73
					Utilities.createCountrie("Ghana"), // 74
					Utilities.createCountrie("Gibraltar"), // 75
					Utilities.createCountrie("Granada"), // 76
					Utilities.createCountrie("Grecia"), // 77
					Utilities.createCountrie("Groenlandia"), // 78
					Utilities.createCountrie("Guadalupe"), // 79
					Utilities.createCountrie("Guam"), // 80
					Utilities.createCountrie("Guatemala"), // 81
					Utilities.createCountrie("Guayana Francesa"), // 82
					Utilities.createCountrie("Guernsey"), // 83
					Utilities.createCountrie("Guinea"), // 84
					Utilities.createCountrie("Guinea Ecuatorial"), // 85
					Utilities.createCountrie("Guinea-Bissau"), // 86
					Utilities.createCountrie("Guyana"), // 87
					Utilities.createCountrie("Haití"), // 88
					Utilities.createCountrie("Honduras"), // 89
					Utilities.createCountrie("Hong kong"), // 90
					Utilities.createCountrie("Hungría"), // 91
					Utilities.createCountrie("India"), // 92
					Utilities.createCountrie("Indonesia"), // 93
					Utilities.createCountrie("Irán"), // 94
					Utilities.createCountrie("Irak"), // 95
					Utilities.createCountrie("Irlanda"), // 96
					Utilities.createCountrie("Isla Bouvet"), // 97
					Utilities.createCountrie("Isla de Man"), // 98
					Utilities.createCountrie("Isla de Navidad"), // 99
					Utilities.createCountrie("Isla Norfolk"), // 100
					Utilities.createCountrie("Islandia"), // 101
					Utilities.createCountrie("Islas Bermudas"), // 102
					Utilities.createCountrie("Islas Caimán"), // 103
					Utilities.createCountrie("Islas Cocos (Keeling)"), // 104
					Utilities.createCountrie("Islas Cook"), // 105
					Utilities.createCountrie("Islas de Åland"), // 106
					Utilities.createCountrie("Islas Feroe"), // 107
					Utilities.createCountrie("Islas Georgias del Sur y Sandwich del Sur"), // 108
					Utilities.createCountrie("Islas Heard y McDonald"), // 109
					Utilities.createCountrie("Islas Maldivas"), // 110
					Utilities.createCountrie("Islas Malvinas"), // 111
					Utilities.createCountrie("Islas Marianas del Norte"), // 112
					Utilities.createCountrie("Islas Marshall"), // 113
					Utilities.createCountrie("Islas Pitcairn"), // 114
					Utilities.createCountrie("Islas Salomón"), // 115
					Utilities.createCountrie("Islas Turcas y Caicos"), // 116
					Utilities.createCountrie("Islas Ultramarinas Menores de Estados Unidos"), // 117
					Utilities.createCountrie("Islas Vírgenes Británicas"), // 118
					Utilities.createCountrie("Islas Vírgenes de los Estados Unidos"), // 119
					Utilities.createCountrie("Israel"), // 120
					Utilities.createCountrie("Italia"), // 121
					Utilities.createCountrie("Jamaica"), // 122
					Utilities.createCountrie("Japón"), // 123
					Utilities.createCountrie("Jersey"), // 124
					Utilities.createCountrie("Jordania"), // 125
					Utilities.createCountrie("Kazajistán"), // 126
					Utilities.createCountrie("Kenia"), // 127
					Utilities.createCountrie("Kirgizstán"), // 128
					Utilities.createCountrie("Kiribati"), // 129
					Utilities.createCountrie("Kuwait"), // 130
					Utilities.createCountrie("Líbano"), // 131
					Utilities.createCountrie("Laos"), // 132
					Utilities.createCountrie("Lesoto"), // 133
					Utilities.createCountrie("Letonia"), // 134
					Utilities.createCountrie("Liberia"), // 135
					Utilities.createCountrie("Libia"), // 136
					Utilities.createCountrie("Liechtenstein"), // 137
					Utilities.createCountrie("Lituania"), // 138
					Utilities.createCountrie("Luxemburgo"), // 139
					Utilities.createCountrie("México"), // 140
					Utilities.createCountrie("Mónaco"), // 141
					Utilities.createCountrie("Macao"), // 142
					Utilities.createCountrie("Macedônia"), // 143
					Utilities.createCountrie("Madagascar"), // 144
					Utilities.createCountrie("Malasia"), // 145
					Utilities.createCountrie("Malawi"), // 146
					Utilities.createCountrie("Mali"), // 147
					Utilities.createCountrie("Malta"), // 148
					Utilities.createCountrie("Marruecos"), // 149
					Utilities.createCountrie("Martinica"), // 150
					Utilities.createCountrie("Mauricio"), // 151
					Utilities.createCountrie("Mauritania"), // 152
					Utilities.createCountrie("Mayotte"), // 153
					Utilities.createCountrie("Micronesia"), // 154
					Utilities.createCountrie("Moldavia"), // 155
					Utilities.createCountrie("Mongolia"), // 156
					Utilities.createCountrie("Montenegro"), // 157
					Utilities.createCountrie("Montserrat"), // 158
					Utilities.createCountrie("Mozambique"), // 159
					Utilities.createCountrie("Namibia"), // 160
					Utilities.createCountrie("Nauru"), // 161
					Utilities.createCountrie("Nepal"), // 162
					Utilities.createCountrie("Nicaragua"), // 163
					Utilities.createCountrie("Niger"), // 164
					Utilities.createCountrie("Nigeria"), // 165
					Utilities.createCountrie("Niue"), // 166
					Utilities.createCountrie("Noruega"), // 167
					Utilities.createCountrie("Nueva Caledonia"), // 168
					Utilities.createCountrie("Nueva Zelanda"), // 169
					Utilities.createCountrie("Omán"), // 170
					Utilities.createCountrie("Países Bajos"), // 171
					Utilities.createCountrie("Pakistán"), // 172
					Utilities.createCountrie("Palau"), // 173
					Utilities.createCountrie("Palestina"), // 174
					Utilities.createCountrie("Panamá"), // 175
					Utilities.createCountrie("Papúa Nueva Guinea"), // 176
					Utilities.createCountrie("Paraguay"), // 177
					Utilities.createCountrie("Perú"), // 178
					Utilities.createCountrie("Polinesia Francesa"), // 179
					Utilities.createCountrie("Polonia"), // 180
					Utilities.createCountrie("Portugal"), // 181
					Utilities.createCountrie("Puerto Rico"), // 182
					Utilities.createCountrie("Qatar"), // 183
					Utilities.createCountrie("Reino Unido"), // 184
					Utilities.createCountrie("República Centroafricana"), // 185
					Utilities.createCountrie("República Checa"), // 186
					Utilities.createCountrie("República Dominicana"), // 187
					Utilities.createCountrie("Reunión"), // 188
					Utilities.createCountrie("Ruanda"), // 189
					Utilities.createCountrie("Rumanía"), // 190
					Utilities.createCountrie("Rusia"), // 191
					Utilities.createCountrie("Sahara Occidental"), // 192
					Utilities.createCountrie("Samoa"), // 193
					Utilities.createCountrie("Samoa Americana"), // 194
					Utilities.createCountrie("San Bartolomé"), // 195
					Utilities.createCountrie("San Cristóbal y Nieves"), // 196
					Utilities.createCountrie("San Marino"), // 197
					Utilities.createCountrie("San Martín (Francia)"), // 198
					Utilities.createCountrie("San Pedro y Miquelón"), // 199
					Utilities.createCountrie("San Vicente y las Granadinas"), // 200
					Utilities.createCountrie("Santa Elena"), // 201
					Utilities.createCountrie("Santa Lucía"), // 202
					Utilities.createCountrie("Santo Tomé y Príncipe"), // 203
					Utilities.createCountrie("Senegal"), // 204
					Utilities.createCountrie("Serbia"), // 205
					Utilities.createCountrie("Seychelles"), // 206
					Utilities.createCountrie("Sierra Leona"), // 207
					Utilities.createCountrie("Singapur"), // 208
					Utilities.createCountrie("Siria"), // 209
					Utilities.createCountrie("Somalia"), // 210
					Utilities.createCountrie("Sri lanka"), // 211
					Utilities.createCountrie("Sudáfrica"), // 212
					Utilities.createCountrie("Sudán"), // 213
					Utilities.createCountrie("Suecia"), // 214
					Utilities.createCountrie("Suiza"), // 215
					Utilities.createCountrie("Surinám"), // 216
					Utilities.createCountrie("Svalbard y Jan Mayen"), // 217
					Utilities.createCountrie("Swazilandia"), // 218
					Utilities.createCountrie("Tadjikistán"), // 219
					Utilities.createCountrie("Tailandia"), // 220
					Utilities.createCountrie("Taiwán"), // 221
					Utilities.createCountrie("Tanzania"), // 222
					Utilities.createCountrie("Territorio Británico del Océano Índico"), // 223
					Utilities.createCountrie("Territorios Australes y Antárticas Franceses"), // 224
					Utilities.createCountrie("Timor Oriental"), // 225
					Utilities.createCountrie("Togo"), // 226
					Utilities.createCountrie("Tokelau"), // 227
					Utilities.createCountrie("Tonga"), // 228
					Utilities.createCountrie("Trinidad y Tobago"), // 229
					Utilities.createCountrie("Tunez"), // 230
					Utilities.createCountrie("Turkmenistán"), // 231
					Utilities.createCountrie("Turquía"), // 232
					Utilities.createCountrie("Tuvalu"), // 233
					Utilities.createCountrie("Ucrania"), // 234
					Utilities.createCountrie("Uganda"), // 235
					Utilities.createCountrie("Uruguay"), // 236
					Utilities.createCountrie("Uzbekistán"), // 237
					Utilities.createCountrie("Vanuatu"), // 238
					Utilities.createCountrie("Venezuela"), // 239
					Utilities.createCountrie("Vietnam"), // 240
					Utilities.createCountrie("Wallis y Futuna"), // 241
					Utilities.createCountrie("Yemen"), // 242
					Utilities.createCountrie("Yibuti"), // 243
					Utilities.createCountrie("Zambia"), // 244
					Utilities.createCountrie("Zimbabue") // 245
			};

			Province provs[] = { Utilities.createProvince("Misiones", 54), // 1
					Utilities.createProvince("San Luis", 74), // 2
					Utilities.createProvince("San Juan", 70), // 3
					Utilities.createProvince("Entre Rï¿½os", 30), // 4
					Utilities.createProvince("Santa Cruz", 78), // 5
					Utilities.createProvince("Rï¿½o Negro", 62), // 6
					Utilities.createProvince("Chubut", 26), // 7
					Utilities.createProvince("Cï¿½rdoba", 14), // 8
					Utilities.createProvince("Mendoza", 50), // 9
					Utilities.createProvince("La Rioja", 46), // 10
					Utilities.createProvince("Catamarca", 10), // 11
					Utilities.createProvince("La Pampa", 42), // 12
					Utilities.createProvince("Santiago del Estero", 86), // 13
					Utilities.createProvince("Corrientes", 18), // 14
					Utilities.createProvince("Santa Fe", 82), // 15
					Utilities.createProvince("Tucumï¿½n", 90), // 16
					Utilities.createProvince("Neuquï¿½n", 58), // 17
					Utilities.createProvince("Salta", 66), // 18
					Utilities.createProvince("Chaco", 22), // 19
					Utilities.createProvince("Formosa", 34), // 20
					Utilities.createProvince("Jujuy", 38), // 21
					Utilities.createProvince("Ciudad Autï¿½noma de Buenos Aires", 02), // 22
					Utilities.createProvince("Buenos Aires", 06), // 23
					Utilities.createProvince("Tierra del Fuego", 94), // 24
			};

			City cities[] = { Utilities.createCity("02000010000", "CIUDAD DE BUENOS AIRES", provs[21]), // 1
					Utilities.createCity("02007010001", "CONSTITUCION", provs[21]), // 2
					Utilities.createCity("14014010000", "Cï¿½RDOBA", provs[7]), // 3
			};
			//

			// USUARIOs
			User user = Utilities.createUser("123456", "Carlos", "Cliente");
			User user2 = Utilities.createUser("123456", "Pablo", "Cliente");
			User user3 = Utilities.createUser("123456", "Ellen", "Cliente");
			User user4 = Utilities.createUser("123456", "Sundar", "Cliente");
			User user5 = Utilities.createUser("123456", "David", "Cliente");
			User user6 = Utilities.createUser("123456", "Hermann", "Cliente");
			User user7 = Utilities.createUser("123456", "Alexis", "Cliente");
			User user8 = Utilities.createUser("123456", "Alberto", "Cliente");
			User user9 = Utilities.createUser("123456", "Curtis", "Cliente");
			User user10 = Utilities.createUser("123456", "Kevin", "Cliente");

			User admin = Utilities.createUser("123456", "Juanc", "Admin");

			typeAccount ta = Utilities.createTypeAccount("Caja de Ahorro en Pesos", true);
			typeAccount ta2 = Utilities.createTypeAccount("Caja de Ahorro en Dï¿½lares", false);
			typeAccount ta3 = Utilities.createTypeAccount("Cuenta Corriente", true);
			typeAccount ta4 = Utilities.createTypeAccount("Cuenta Corriente Especial en Pesos", true);
			typeAccount ta5 = Utilities.createTypeAccount("Cuenta Corriente Especial en Dï¿½lares", false);

			Genre gen = Utilities.createGenre("Femenino");
			Genre gen2 = Utilities.createGenre("Masculino");
			Genre gen3 = Utilities.createGenre("Otro");

			// CLIENTE
			Client client = Utilities.createClient(new Date(), cities[1], "32235422", "carlos@gmail.com", "Carlos",
					"Rodriguez", countries[11], provs[21], gen3, user);
			Client client2 = Utilities.createClient(new Date(), cities[2], "23232323", "pablo@gmail.com", "Pablo",
					"Escobar", countries[44], provs[21], gen2, user2);

			Client client3 = Utilities.createClient(Cmd.crearFecha(6, 12, 1980), cities[1], "18654923",
					"Eabel@gmail.com", "Ellen", "Abel", countries[11], provs[21], gen, user3);

			Client client4 = Utilities.createClient(Cmd.crearFecha(3, 8, 1985), cities[0], "23654956",
					"Sande@gmail.com", "Sundar", "Ande", countries[11], provs[21], gen3, user4);

			Client client5 = Utilities.createClient(Cmd.crearFecha(14, 6, 1989), cities[1], "24632589",
					"daustin@gmail.com", "David", "Austin", countries[11], provs[21], gen2, user5);

			Client client6 = Utilities.createClient(Cmd.crearFecha(22, 1, 1990), cities[1], "30652987",
					"hbaer@gmail.com", "Hermann", "Baer", countries[11], provs[21], gen2, user6);

			Client client7 = Utilities.createClient(Cmd.crearFecha(19, 5, 1992), cities[2], "35621785",
					"abull@gmail.com", "Alexis", "Bull", countries[11], provs[21], gen, user7);

			Client client8 = Utilities.createClient(Cmd.crearFecha(28, 2, 1996), cities[0], "39632541",
					"aerrazur@gmail.com", "Alberto", "Errazuriz", countries[11], provs[7], gen2, user8);

			Client client9 = Utilities.createClient(Cmd.crearFecha(2, 2, 1998), cities[1], "35621478",
					"cdavies@gmail.com", "Curtis", "Davies", countries[11], provs[19], gen2, user9);

			Client client10 = Utilities.createClient(Cmd.crearFecha(13, 8, 1997), cities[0], "40654951",
					"kfeeney@gmail.com", "Kevin", "Feeney", countries[11], provs[11], gen3, user10);

			// CUENTA
			Date fecha = Cmd.crearFechaHora(10, 5, 2020, 12, 12, 12);
			Account acc = Utilities.createAccount(client, "12321323213", fecha, 32323.4F, "Cuenta 1", 0, null, null,
					ta);
			fecha = Cmd.crearFechaHora(10, 1, 2019, 10, 22, 12);
			Account acc2 = Utilities.createAccount(client2, "68686868686545", fecha, 45000F, "Cuenta 2", 1, null, null,
					ta3);
			fecha = Cmd.crearFechaHora(22, 2, 2020, 31, 2, 12);
			Account acc3 = Utilities.createAccount(client, "5473767373356", fecha, 333.03F, "Cuenta 3", 2, null, null,
					ta4);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc4 = Utilities.createAccount(client3, "59598123156651", fecha, 90000.50F, "Cuenta 1", 2, null,
					null, ta3);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc5 = Utilities.createAccount(client4, "323269444845261", fecha, 10000000F, "Cuenta 2", 2, null,
					null, ta);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc6 = Utilities.createAccount(client5, "2215198431218912", fecha, 51510F, "Cuenta 3", 2, null,
					null, ta2);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc7 = Utilities.createAccount(client6, "454612354984561", fecha, 100000F, "Cuenta 1", 1, null,
					null, ta);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc8 = Utilities.createAccount(client7, "5954841631566", fecha, 45.5F, "Cuenta 1", 2, null, null,
					ta);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc9 = Utilities.createAccount(client8, "88451231561231", fecha, 102000.3F, "Cuenta 1", 2, null,
					null, ta3);
			fecha = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Account acc10 = Utilities.createAccount(client9, "99218913621", fecha, 5.5F, "Cuenta 1", 2, null, null, ta);

			// TIPOS DE MOVIMIENTO
			typeMove tm = Utilities.createTypeMove("Alta de Cuenta", true);
			typeMove tm2 = Utilities.createTypeMove("Alta de Prestamo", true);
			typeMove tm3 = Utilities.createTypeMove("Pago de Prestamo", false);
			typeMove tm4 = Utilities.createTypeMove("Transferencia Realizada", false);
			typeMove tm5 = Utilities.createTypeMove("Transferencia Recibida", true);

			// TRANSACCION
			Date date = Cmd.crearFechaHora(10, 5, 2020, 12, 12, 12);
			Transaction trans = Utilities.createTransaction(2000F, "Pagos", date, null, null, tm3);
			date = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Transaction trans2 = Utilities.createTransaction(2500F, "Pago cuota", date, null, null, tm3);
			date = Cmd.crearFechaHora(25, 3, 2019, 11, 42, 12);
			Transaction trans3 = Utilities.createTransaction(2500F, "Alquiler", date, null, null, tm4);
			date = Cmd.crearFechaHora(15, 4, 2020, 18, 45, 12);
			Transaction trans4 = Utilities.createTransaction(45000F, "Pago cuota", date, null, null, tm2);
			date = Cmd.crearFechaHora(30, 1, 2020, 10, 45, 45);
			Transaction trans5 = Utilities.createTransaction(10000F, "Otros", date, null, null, tm5);
			date = Cmd.crearFechaHora(18, 5, 2019, 12, 12, 23);
			Transaction trans6 = Utilities.createTransaction(2666F, "Pago cuota", date, null, null, tm3);
			date = Cmd.crearFechaHora(10, 2, 2020, 19, 46, 22);
			Transaction trans7 = Utilities.createTransaction(25000F, "Transaccion", date, null, null, tm5);
			date = Cmd.crearFechaHora(10, 3, 2020, 11, 45, 12);
			Transaction trans8 = Utilities.createTransaction(2500F, "Pago cuota", date, null, null, tm3);
			date = Cmd.crearFechaHora(10, 4, 2020, 10, 00, 12);
			Transaction trans9 = Utilities.createTransaction(2500F, "Pago cuota", date, null, null, tm3);
			date = Cmd.crearFechaHora(10, 5, 2020, 19, 00, 01);
			Transaction trans10 = Utilities.createTransaction(2500F, "Pago cuota", date, null, null, tm3);

			trans.setDestinationAccount(acc);
			trans.setOriginAccount(acc2);

			trans2.setDestinationAccount(acc);
			trans2.setOriginAccount(acc5);

			trans3.setDestinationAccount(acc2);
			trans3.setOriginAccount(acc10);

			trans4.setDestinationAccount(acc10);
			trans4.setOriginAccount(acc4);

			trans5.setDestinationAccount(acc5);
			trans5.setOriginAccount(acc6);

			trans6.setDestinationAccount(acc7);
			trans6.setOriginAccount(acc8);

			trans7.setDestinationAccount(acc9);
			trans7.setOriginAccount(acc);

			trans8.setDestinationAccount(acc10);
			trans8.setOriginAccount(acc2);

			trans9.setDestinationAccount(acc7);
			trans9.setOriginAccount(acc6);

			trans10.setDestinationAccount(acc5);
			trans10.setOriginAccount(acc3);

			ArrayList<Transaction> hisTrans = new ArrayList<Transaction>();
			hisTrans.add(trans);
			hisTrans.add(trans2);

			ArrayList<Transaction> hisTrans2 = new ArrayList<Transaction>();
			hisTrans2.add(trans3);

			ArrayList<Transaction> hisTrans5 = new ArrayList<Transaction>();
			hisTrans5.add(trans5);
			hisTrans5.add(trans10);

			ArrayList<Transaction> hisTrans7 = new ArrayList<Transaction>();
			hisTrans7.add(trans6);
			hisTrans7.add(trans9);

			ArrayList<Transaction> hisTrans9 = new ArrayList<Transaction>();
			hisTrans9.add(trans7);

			ArrayList<Transaction> hisTrans10 = new ArrayList<Transaction>();
			hisTrans10.add(trans4);
			hisTrans10.add(trans8);

			// CUENTAS

			// Aca agrego las transaccion
			acc.setTransactionMade(hisTrans);
			acc2.setTransactionMade(hisTrans2);
			acc5.setTransactionMade(hisTrans5);
			acc7.setTransactionMade(hisTrans7);
			acc9.setTransactionMade(hisTrans9);
			acc10.setTransactionMade(hisTrans10);

			// USUARIO BANCO
			Administrative adm = Utilities.createAdministrative("22365986", "Juancho@hotmail.es", "Juan", "Acosta",
					admin);
			// Administrative adm2 = Utilities.createAdministrative("33009922",
			// "jony@hotmail.es", "Jonathan", "Aceite",
			// admin);

			// PRESTAMO
			Loan loan = Utilities.createLoan(client, 2323F, date, 3, 774.33F);
			date = Cmd.crearFechaHora(10, 2, 2020, 11, 45, 12);
			Loan loan2 = Utilities.createLoan(client, 200F, date, 1, 200F);
			date = Cmd.crearFechaHora(10, 2, 2019, 11, 45, 12);
			Loan loan3 = Utilities.createLoan(client, 2000F, date, 1, 2000F);
			date = Cmd.crearFechaHora(12, 1, 2020, 11, 45, 12);
			Loan loan4 = Utilities.createLoan(client, 4500F, date, 3, 1500F);
			date = Cmd.crearFechaHora(4, 1, 2020, 13, 25, 12);
			Loan loan5 = Utilities.createLoan(client, 3000F, date, 3, 1000F);
			date = Cmd.crearFechaHora(1, 1, 2020, 13, 4, 55);
			Loan loan6 = Utilities.createLoan(client, 6000F, date, 3, 2000F);
			date = Cmd.crearFechaHora(10, 3, 2020, 11, 45, 12);
			Loan loan7 = Utilities.createLoan(client, 10000F, date, 1, 10000F);
			date = Cmd.crearFechaHora(16, 2, 2020, 12, 45, 12);
			Loan loan8 = Utilities.createLoan(client, 6000F, date, 1, 6000F);
			date = Cmd.crearFechaHora(18, 2, 2019, 15, 32, 12);
			Loan loan9 = Utilities.createLoan(client, 120000F, date, 3, 40000F);
			date = Cmd.crearFechaHora(9, 2, 2018, 11, 11, 11);
			Loan loan10 = Utilities.createLoan(client, 60000F, date, 3, 20000F);

			// CUOTAs
			FeePayment fp = Utilities.creatFeePayment(loan.getMonthAmmount(),
					Cmd.crearFechaHora(10, 3, 2020, 12, 11, 11));
			FeePayment fp2 = Utilities.creatFeePayment(loan.getMonthAmmount(),
					Cmd.crearFechaHora(10, 4, 2020, 15, 33, 11));
			FeePayment fp3 = Utilities.creatFeePayment(loan.getMonthAmmount(),
					Cmd.crearFechaHora(10, 5, 2020, 13, 55, 11));
			ArrayList<FeePayment> fpList = new ArrayList<FeePayment>();
			fpList.add(fp);
			fpList.add(fp2);
			fpList.add(fp3);
			loan.setPayments(fpList);

			ArrayList<FeePayment> fpList2 = new ArrayList<FeePayment>();
			FeePayment fp4 = Utilities.creatFeePayment(loan2.getMonthAmmount(),
					Cmd.crearFechaHora(10, 3, 2019, 12, 11, 11));
			fpList2.add(fp4);
			loan2.setPayments(fpList2);

			ArrayList<FeePayment> fpList3 = new ArrayList<FeePayment>();
			FeePayment fp5 = Utilities.creatFeePayment(loan3.getMonthAmmount(),
					Cmd.crearFechaHora(12, 2, 2020, 11, 45, 12));
			FeePayment fp6 = Utilities.creatFeePayment(loan3.getMonthAmmount(),
					Cmd.crearFechaHora(12, 3, 2020, 11, 45, 12));
			FeePayment fp7 = Utilities.creatFeePayment(loan3.getMonthAmmount(),
					Cmd.crearFechaHora(12, 4, 2020, 11, 45, 12));
			fpList3.add(fp5);
			fpList3.add(fp6);
			fpList3.add(fp7);
			loan4.setPayments(fpList3);

			ArrayList<FeePayment> fpList4 = new ArrayList<FeePayment>();
			FeePayment fp8 = Utilities.creatFeePayment(loan3.getMonthAmmount(),
					Cmd.crearFechaHora(4, 2, 2020, 13, 25, 12));
			FeePayment fp9 = Utilities.creatFeePayment(loan3.getMonthAmmount(),
					Cmd.crearFechaHora(4, 3, 2020, 9, 25, 12));
			FeePayment fp10 = Utilities.creatFeePayment(loan3.getMonthAmmount(),
					Cmd.crearFechaHora(4, 4, 2020, 11, 25, 12));
			fpList4.add(fp8);
			fpList4.add(fp9);
			fpList4.add(fp10);
			loan5.setPayments(fpList4);

			for (Countrie c : countries) {
				session.save(c);
			}

			for (Province p : provs) {
				session.save(p);
			}

			for (City c : cities) {
				session.save(c);
			}

			session.save(gen);
			session.save(gen2);
			session.save(gen3);

			session.save(ta);
			session.save(ta2);
			session.save(ta3);
			session.save(ta4);
			session.save(ta5);

			session.save(ta);
			session.save(tm2);
			session.save(tm3);
			session.save(tm4);
			session.save(tm5);

			// GUARDAR
			session.save(trans);
			// Guardando clientes
			session.save(client);
			session.save(client2);
			session.save(client3);
			session.save(client4);
			session.save(client5);
			session.save(client6);
			session.save(client7);
			session.save(client8);
			session.save(client9);
			session.save(client10);
			// --
			session.save(acc);
			session.save(acc2);
			session.save(acc3);
			session.save(acc4);
			session.save(acc5);
			session.save(acc6);
			session.save(acc7);
			session.save(acc8);
			session.save(acc9);
			session.save(acc10);

			session.save(loan);
			session.save(loan2);
			session.save(loan3);
			session.save(loan4);
			session.save(loan5);
			session.save(loan6);
			session.save(loan7);
			session.save(loan8);
			session.save(loan9);
			session.save(loan10);
			session.save(adm);
			// session.save(adm2);

			session.getTransaction().commit();
			session.close();
			sf.close();
		} catch (Exception ex) {
			System.err.println("Problem in Open Session." + ex);
		}
	}
}
