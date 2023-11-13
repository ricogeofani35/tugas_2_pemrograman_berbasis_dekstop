import java.util.Scanner;
import java.util.ArrayList;

//class utama
public class ProgramRestoran2 {
	public static void main(String args[]) {
		boolean isMenu = true;
		//set array pemesanan
		// Inisialisasi ArrayList untuk menyimpan menu
        ArrayList<MenuItem> menu = new ArrayList<>();
      //set arraylist pemesanan
        SimpanPesanan[] pesanan = new SimpanPesanan[100];

        // Menambahkan item-menu awal
        menu.add(new MenuItem(1, "Nasi Goreng", 15000, "makanan"));
        menu.add(new MenuItem(2, "Mie Goreng", 12000, "makanan"));
        menu.add(new MenuItem(3, "Ayam Goreng", 20000, "makanan"));
        menu.add(new MenuItem(4, "Es Teh", 10000, "minuman"));
        menu.add(new MenuItem(5, "Es Kelapa Muda", 6000, "minuman"));


//		set scanner from library scanner
		Scanner scanner = new Scanner(System.in);
		
		//menu utama
		System.out.println("------------------------------");
		System.out.println("----Manajemen Menu Aplikasi---");
		System.out.println("------------------------------");
//		kembali ke menu utama
		menuUtama:
		while(isMenu) {
			System.out.println("-------- Menu No : 1 ---------");
			System.out.println("------------------------------");
			System.out.println("------Manajemen Pesanan-------");
			System.out.println("------------------------------");
			System.out.println("-------- Menu No : 2 ---------");
			System.out.println("------------------------------");
			System.out.println("------Manajemen Menu------");
			System.out.println("------------------------------");
			
//			input pilihan menu utama
			System.out.print("Pilih Menu (1 - 2) : ");
			String pilMenu = scanner.nextLine();
			if (!pilMenu.matches("[1-2]*")) {
				System.out.println("------------------------------");
			    System.out.println(">>>Menu Tidak Ada!<<<");
			    continue ;
			} 
			
//			pilih menu utama
			switch(pilMenu) {
//			case manajemen pesanan
				case "1":
//					manajemen pesanan
					System.out.println("------------------------------");
					System.out.println("-------Manajemen Pesanan------");
					System.out.println("------------------------------");
					System.out.println("-- 1. Pilih Pesanan	        --");
					System.out.println("-- 2. Kembali Ke Menu Utama --");
					System.out.println("------------------------------");
					System.out.print("Masukan Pilihan Action(1-2): ");
					String actionMenuPesanan = scanner.nextLine();
//					validasi input menu pesanan
					if (!actionMenuPesanan.matches("[1-2]*")) {
						System.out.println("------------------------------");
					    System.out.println(">>>pilihan action tidak ada!<<<");
					    continue;
					} 
					
//					jika action memilih pesanan
					if(actionMenuPesanan.equals("1")) {
						
						//get method tampilan menu
						tampilMenu(menu);
						
						//get method pilihMenu
						pilihMenu(pesanan, menu, scanner);
						
						//get method tampilTransaksiPesanan
				        tampilTransaksiPesanan(pesanan, scanner);	
				      //close scanner
						scanner.close();
						isMenu = false;
//						jika memilih kembali ke menu utama
					} else if(actionMenuPesanan.equals("2")) {
						continue menuUtama;
					} else {
//						jika pilihan action tidak ada
						System.out.println("------------------------------");
					    System.out.println(">>>pilihan action tidak ada!<<<");
					    continue;
					}
					
				break;
//				case manajemen menu
				case "2":
//					tampil manajemen menu
					tampilManajemenMenu();
//					input manajemen menu
					System.out.print("Masukan Pilihan Action(1-5): ");
					String pilAction = scanner.nextLine();
					//validasi input menu
					if (!pilAction.matches("[1-5]*")) {
						System.out.println("------------------------------");
					    System.out.println(">>>pilihan action tidak ada!<<<");
					    continue;
					} 
//					pilih manajemen menu
					switch(pilAction) {
//					display menu
						case "1":
							boolean menuItem = true;
//							tampilkan menu
							while(menuItem) {
								//get method dataMenuMakananMinuman
								tampilMenu(menu);
//								input kembali ke menu utama
								System.out.print("Kembali ke Menu(ya): ");
								String isBack = scanner.nextLine();
//								validasi
								if (!isBack.matches("ya")) {
									System.out.println("------------------------------");
									System.out.println(">>>pilihan tidak ada!<<<");
									continue;
								} 	
								
								isBack = (isBack.matches("ya")) ? "true" : "false";
						        boolean pilihan = Boolean.parseBoolean(isBack);
								if(pilihan == true) {
									continue menuUtama;
								} 								
							}
							break;
						case "2":
//							tambah item menu
							System.out.println("------------------------------");
							System.out.println("------Tambah Item Menu------");
							System.out.println("------------------------------");
//							input item menu
							for(int i = 5; i <= menu.size(); i++) {
//								input nama
								System.out.print("Masukan Nama : " );
								String nama = scanner.nextLine();
								//validasi input jumlah pesanan
								if (!nama.matches("[a-z ]*")) {
									System.out.println("------------------------------");
								    System.out.println(">>>Input Nama Tidak Ada!<<<");
								    continue;
								} 
//								input harga
								System.out.print("Masukan Harga : ");
								String strHarga = scanner.nextLine();
								if (!strHarga.matches("[0-9]*")) {
									System.out.println("------------------------------");
								    System.out.println(">>>Input Harga Tidak Ada!<<<");
								    continue;
								} 
								Double harga = Double.parseDouble(strHarga);
//								input kategori
								System.out.print("Masukan kategori\nmakanan/minuman: ");
								String kategori = scanner.nextLine();
								if (!kategori.matches("makanan|minuman")) {
									System.out.println("------------------------------");
								    System.out.println(">>>Input Kategori Tidak Ada!<<<");
								    continue;
								} 
								
								//set array pemesanan
								int index = i + 1;
//								masukan data input ke menu dengan index i
								menu.add(new MenuItem(index, nama, harga, kategori));
								System.out.println(">>>Data Menu Berhasil Ditambah<<<");

//								pilihan tambah lagi
								System.out.println("------------------------------");
								System.out.print("Tambah Data Lagi?(ya/tidak) : ");
//								input tambah lagi
								String tambah = scanner.nextLine();
								if (!tambah.matches("ya|tidak")) {
									System.out.println("------------------------------");
								    System.out.println(">>>Pilihan Tidak Ada!<<<");
								    continue;
								} 
								System.out.println("------------------------------");
//								kembali ke menu utama
								tambah = (tambah.matches("ya")) ? "true" : "false";
						        boolean isTambah = Boolean.parseBoolean(tambah);
								if(!isTambah) {
									continue menuUtama;
								}
							}
							
							break;
						case "3":
//							edit item menu
							boolean isEdit = true;
							
							while(isEdit) {
//								tampilkan menu
								tampilMenu(menu);
//								input menu yang ingin diedit
								System.out.print("Masukan Pilihan Menu(1 - " + countMenu(menu) + "): ");
								String pilMenuEdit = scanner.nextLine();
								if (!pilMenuEdit.matches("[1-" + countMenu(menu) + "]*")) {
									System.out.println("------------------------------");
								    System.out.println(">>>Pilihan Tidak Ada!<<<");
								    continue;
								} 
								int indexMenu = Integer.parseInt(pilMenuEdit);
								indexMenu = indexMenu - 1;
								//if jika data tidak ada
								if(menu.get(indexMenu) != null) {
//									menampilkan item yang mau diedit
									System.out.println("------------------------------");
									System.out.println("-------- Menu No : " + menu.get(indexMenu).getId() + " ---------");
									System.out.println("------------------------------");
									System.out.println("Nama : " + menu.get(indexMenu).getNama());
									System.out.println("Harga : " + menu.get(indexMenu).getHarga());
									System.out.println("kategori : " + menu.get(indexMenu).getKategori());
									System.out.println("------------------------------");
									System.out.println("----------Edit Item Menu-----------");
									System.out.println("------------------------------");
//									input nama item
									System.out.print("Masukan Nama : " );
									String nama = scanner.nextLine();
									//validasi input jumlah pesanan
									if (!nama.matches("[a-z ]*")) {
										System.out.println("------------------------------");
									    System.out.println(">>>Input Nama Tidak Ada!<<<");
									    continue;
									} 
//									input harga item
									System.out.print("Masukan Harga : ");
									String strHarga = scanner.nextLine();
									if (!strHarga.matches("[0-9]*")) {
										System.out.println("------------------------------");
									    System.out.println(">>>Input Harga Tidak Ada!<<<");
									    continue;
									} 
									Double harga = Double.parseDouble(strHarga);
//									input kategori item
									System.out.print("Masukan kategori\nmakanan/minuman: ");
									String kategori = scanner.nextLine();
									if (!kategori.matches("makanan|minuman")) {
										System.out.println("------------------------------");
									    System.out.println(">>>Input Kategori Tidak Ada!<<<");
									    continue;
									} 
//									pilihan update atau tidak
									System.out.println("------------------------------");
									System.out.print("Update item menu(ya/tidak): ");
									String isUpdate = scanner.nextLine();
//									validasi
									if (!isUpdate.matches("ya|tidak")) {
										System.out.println("------------------------------");
										System.out.println(">>>pilihan tidak ada!<<<");
										continue;
									} 	
									
									isUpdate = (isUpdate.matches("ya")) ? "true" : "false";
							        boolean pilihan = Boolean.parseBoolean(isUpdate);
									if(!pilihan) {
										System.out.println(">>>Data Menu Gagal Diupdate<<<");
										continue menuUtama;
									} 
//									ambil id menu
									int id = menu.get(indexMenu).getId();
//									ubah menu berdasarkan id
									menu.set(indexMenu, new MenuItem(id, nama, harga, kategori));		
									
									System.out.println(">>>Data Menu Berhasil Diupdate<<<");
									
									continue menuUtama;
								}
							}
							break;
						case "4":
//							hapus item menu
//							display menu yang mau dihapus
								tampilMenu(menu);
								System.out.print("Masukan No Menu yang Dihapus(1 - " + countMenu(menu) + "): ");
								String pilMenuHapus = scanner.nextLine();
								if (!pilMenuHapus.matches("[1-" + countMenu(menu) + "]*")) {
									System.out.println("------------------------------");
								    System.out.println(">>>Pilihan Tidak Ada!<<<");
								    continue;
								} 
								int indexMenu = Integer.parseInt(pilMenuHapus);
								indexMenu = indexMenu - 1;

						        // Menghapus menu pada indeks tertentu
						        if (indexMenu >= 0 && indexMenu < menu.size()) {
						           // pilihan hapus menu
						        	System.out.println("------------------------------");
									System.out.print("Hapus item menu(ya/tidak): ");
									String isDelete = scanner.nextLine();
//									validasi
									if (!isDelete.matches("ya|tidak")) {
										System.out.println("------------------------------");
										System.out.println(">>>pilihan tidak ada!<<<");
										continue;
									} 	
														
									isDelete = (isDelete.matches("ya")) ? "true" : "false";
									boolean pilihan = Boolean.parseBoolean(isDelete);
									if(!pilihan) {
										System.out.println(">>>Data Menu Gagal Didelete<<<");
										continue menuUtama;
									} 
//						        	remove item menu
						            menu.remove(indexMenu);
						            
						            System.out.println("Data berhasil Dihapus");
						            continue menuUtama;
						        } else {
						            System.out.println("Indeks diluar batas!");
						            
						        }
							break;
						case "5":
							continue menuUtama;
					}
					isMenu = false;
				}
			}
		}
		
		
	
	public static void tampilManajemenMenu() {
		System.out.println("------------------------------");
		System.out.println("--------Manajemen Menu--------");
		System.out.println("------------------------------");
		System.out.println("-- 1. Tampilkan Menu	    --");
		System.out.println("-- 2. Tambah Menu           --");
		System.out.println("-- 3. Ubah Menu	            --");
		System.out.println("-- 4. Hapus Menu            --");
		System.out.println("-- 5. Kembali Ke Menu Utama --");
		System.out.println("------------------------------");
	}
	
	//method set tampilMenu
	public static void tampilMenu(ArrayList<MenuItem> menu) {
		//tampilan awal
		System.out.println("------------------------------");
		System.out.println("---Menu Makanan dan Minuman---");
		System.out.println("------------------------------");
		for(MenuItem item : menu) {
			//jika data sudah ada
			if(item != null) {
				System.out.println("-------- Menu No : " + item.getId() + " ---------");
				System.out.println("------------------------------");
				System.out.println("Nama : " + item.getNama());
				System.out.println("Harga : " + item.getHarga());
				System.out.println("kategori : " + item.getKategori());
				System.out.println("------------------------------");
			}
		}
	}
	
	//set method pilihMenu
	public static void pilihMenu(SimpanPesanan[] pesanan, ArrayList<MenuItem> menu,Scanner scanner) {
		//variabel boolean
		boolean pesanLagi = true;
		int jmlMenuPesanan = 0;
		//looping menu dan jumlah pesanan
				outerLoop: //label outerLoop
				while(pesanLagi) {
					
						
					System.out.println("------------------------------");
					System.out.println("Jumlah Pesanan Menu : " + jmlMenuPesanan); //jumlah pesanan menu user
					System.out.println("------------------------------");
					
					System.out.print("Masukan Pilihan Menu(1 - " + countMenu(menu) + "): ");
					String pilMenu = scanner.nextLine();
					//validasi input menu
					if (!pilMenu.matches("[1-" + countMenu(menu) + "]*")) {
						System.out.println("------------------------------");
					    System.out.println(">>>pilihan menu tidak ada!<<<");
					    continue;
					} 
					
					System.out.print("Masukan Jumlah Pesanan: ");
					String jmlPesanan = scanner.nextLine();
					//validasi input jumlah pesanan
					if (!jmlPesanan.matches("[0-9]*")) {
						System.out.println("------------------------------");
					    System.out.println(">>>Input Jumlah Pesanan Salah!<<<");
					    continue;
					} 
					
					//jika pesanan sudah ada
					for(SimpanPesanan data : pesanan) {
						if(data != null) {
							String id = Integer.toString(data.getId());
							if (pilMenu.matches(id)) {
								System.out.println("------------------------------");
							    System.out.println(">>>Menu Pilihan Sudah Ada!<<<");
							    continue outerLoop; //akan continue ke label outerLoop
							} 
						}
					}
					
					//input boolean pilihan
					System.out.print("Mau Pesan Lagi(ya/tidak)?: ");
					String isLagi = scanner.nextLine();
					//rubah menjadi huruf kecil
					isLagi = isLagi.toLowerCase();
					
					//validasi input jumlah pesanan
					if (!isLagi.matches("ya|tidak")) {
						System.out.println("------------------------------");
					    System.out.println(">>>Pilihan Tidak Ada!<<<");
					    continue;
					} 
					
			        //convert string menjadi boolean
			        isLagi = (isLagi.matches("ya")) ? "true" : "false";
			        boolean pilihan = Boolean.parseBoolean(isLagi);
			        
			      //isi dengan input boolean (true / false)
					pesanLagi = pilihan;
					
					jmlMenuPesanan++;
					if(jmlMenuPesanan == 5) {
						pesanLagi = false;
					}
					
					//konvert string jmlPesanan ke int jumlah
					int jumlah = Integer.parseInt(jmlPesanan);
					
					//case pilihan menu
					for(int i = 0; i < countMenu(menu); i++) {
						String j = Integer.toString(i + 1);
						if(pilMenu.equals(j)) {
							int index = Integer.parseInt(pilMenu);
							pesanan[index] = new SimpanPesanan(menu.get(index - 1).getId(), menu.get(index - 1).getNama(), menu.get(index - 1).getHarga(), menu.get(index - 1).getKategori(), jumlah);
							break;
						}
					}
					
				}
				
				// ANSI escape code untuk membersihkan layar
		        System.out.print("\033[H\033[2J"); // Windows Command Prompt

				//output pesanan
		        tampilPesanan(jmlMenuPesanan, pesanan, menu, scanner);
	}
	
	//set method tampilPesanan
	public static void tampilPesanan(int jmlMenuPesanan, SimpanPesanan[] pesanan, ArrayList<MenuItem> menu, Scanner scanner) {
		System.out.println("------------------------------");
		System.out.println("---------Data Pesanan---------");
		System.out.println("------------------------------");
		System.out.println("Jumlah Pesanan Menu : " + jmlMenuPesanan); //jumlah pesanan menu user
		System.out.println("------------------------------");
		
	    double subTotal = 0;
	    //looping data pesanan
		for(SimpanPesanan data : pesanan) {
			if(data != null) {
				System.out.println("-------- Menu No : " + data.getId() + " ---------");
				System.out.println("------------------------------");
				System.out.println("Nama : " + data.getNama());
				System.out.println("Harga : " + data.getHarga());
				System.out.println("kategori : " + data.getKategori());
				System.out.println("Jumlah : " + data.getJumlah());
				System.out.println("------------------------------");
				
				//kali harga dan jumlah dan masukan ke variabel subTotal
				subTotal += data.hitungSubTotal();
			}
		}
		
		//get method pilihPromoMinuman
		pilihPromoMinuman(subTotal, pesanan, menu, scanner);
	}
	
//set method pilihPromoMinuman	
	public static void pilihPromoMinuman(double subTotal, SimpanPesanan[] pesanan, ArrayList<MenuItem> menu, Scanner scanner) {
		//jika sub total lebih dari 50000
		if(subTotal > 50000) {
			//tampilkan sub total
        	System.out.println("------------------------------");
    		System.out.println("Sub Total : " + subTotal);
			//input boolean pilihan ambil promo atau tidak
    		boolean isPilihan = true;
    		
    		//looping pilihan jika true
    		while(isPilihan) {
    			System.out.println("------------------------------");
    			System.out.print("Mau Ambil Promo, beli 1 gratis 1,\nuntuk kategori minuman (ya/tidak)?: ");
    			String isPromo = scanner.nextLine();
    			//validasi input menu
				if (!isPromo.matches("ya|tidak")) {
					System.out.println("------------------------------");
				    System.out.println(">>>pilihan tidak ada!<<<");
				    continue;
				} 
    			
    	        //convert string menjadi boolean
    	        isPromo = (isPromo.matches("ya")) ? "true" : "false";
    	        boolean pilihan = Boolean.parseBoolean(isPromo);
    	        
    	        if(pilihan == true) {
    	        	
    	        	//get method tampilMenuPromoMinuman
    	        	tampilMenuPromoMinuman(menu);
    	        	
    	        	System.out.print("Masukan Pilihan Menu(4 - 5) : ");
    				String pilMenu = scanner.nextLine();
    				//validasi input menu
					if (!pilMenu.matches("[4-5]*")) {
						System.out.println("------------------------------");
					    System.out.println(">>>pilihan menu promo tidak ada!<<<");
					    continue;
					} 
					
    				System.out.print("Masukan Jumlah Pesanan: ");
    				String jmlPesanan = scanner.nextLine();
    				//validasi input menu
					if (!jmlPesanan.matches("[0-9]*")) {
						System.out.println("------------------------------");
					    System.out.println(">>>Input Jumlah Pesanan Salah!<<<");
					    continue;
					} 
    				
    				//konvert string jmlPesanan ke int jumlah
    				int jumlah = Integer.parseInt(jmlPesanan);
    				
    				//case pilihan menu
    				switch(pilMenu) {
    					case "4":
    						pesanan[50] = new SimpanPesanan(menu.get(3).getId(), menu.get(3).getNama(), menu.get(3).getHarga(), menu.get(3).getKategori(), jumlah); 
    						break;
    					case "5":
    						pesanan[60] = new SimpanPesanan(menu.get(4).getId(), menu.get(4).getNama(), menu.get(4).getHarga(), menu.get(4).getKategori(), jumlah); 
    						break;
    					default:
    						System.out.println("data menu tidak ada!");
    						
    				}
    				//set menjadi false
        	        isPilihan = false;
    	        } else {
    	        	//set menjadi false
        	        isPilihan = false;
    	        }
    		}
		}
	}
	
//	set method tampilMenuPromoMinuman
	public static void tampilMenuPromoMinuman(ArrayList<MenuItem> menu) {
		System.out.println("------------------------------");
		System.out.println("------Menu Promo Minuman------");
		System.out.println("------------------------------");
    	for(MenuItem item : menu) {
			//jika data sudah ada
			if(item != null && item.getKategori() == "minuman") {
				System.out.println("-------- Menu No : " + item.getId() + " ---------");
				System.out.println("------------------------------");
				System.out.println("Nama : " + item.getNama());
				System.out.println("Harga : " + item.getHarga());
				System.out.println("kategori : " + item.getKategori());
				System.out.println("------------------------------");
				
			}
		}
	}
	
//	set method hitungTransaksi dengan return grandTotal
	public static double hitungTransaksi(SimpanPesanan[] pesanan) {
//		set variabel
		double subTotal = 0;
		double grandTotal = 0;
		double pajak = 0;
		double diskon = 0;
		double pelayanan = 20000;
//		simpan data subTotal dari harga * jumlah
		for(SimpanPesanan data : pesanan) {
			if(data != null) {
				subTotal += data.hitungSubTotal();
			}
		}
		
//		set variabel pajak 10% dan diskon 10%
		pajak = subTotal * 10 / 100;
		diskon = subTotal * 10 / 100;
		
//		set grand total
		grandTotal = (subTotal + pajak) + pelayanan;
		
//		jika sub total lebih dari 100000
		if(subTotal > 100000) {
//			mendapatkan diskon 10%
			grandTotal = grandTotal - diskon;
			System.out.println("Diskon : 10%");
			return grandTotal;
		}
//		return grand total
		return grandTotal;
	}
	
//	set method tampilTransaksiPesanan
	public static void tampilTransaksiPesanan(SimpanPesanan[] pesanan, Scanner scanner) {
		double subTotal = 0;
		System.out.println("------------------------------");
		System.out.println("------Transaksi Pemesanan------");
		System.out.println("------------------------------");
		//looping data pesanan
		for(SimpanPesanan data : pesanan) {
			if(data != null) {
				System.out.println("-------- Menu No : " + data.getId() + " ---------");
				System.out.println("------------------------------");
				System.out.println("Nama : " + data.getNama());
				System.out.println("Harga : " + data.getHarga());
				System.out.println("kategori : " + data.getKategori());
				System.out.println("Jumlah : " + data.getJumlah());
				System.out.println("------------------------------");
				
				//kali harga dan jumlah dan masukan ke variabel subTotal
				subTotal += data.hitungSubTotal();
			}
			
		}
		
		//jika data pesanan di index-5 ada maka tampilkan 
		if(pesanan[5] != null) {
			System.out.println("------------------------------");
			System.out.println("---------Gratis Minuman-------");
			System.out.println(">>Untuk Promo beli 1 gratis 1<<");
			System.out.println("------------------------------");
			System.out.println("Nama : " + pesanan[5].getNama());
			System.out.println("kategori : " + pesanan[5].getKategori());
			System.out.println("Jumlah : " + pesanan[5].getJumlah());
		}
		
		//tampil sub total
		System.out.println("------------------------------");
		System.out.println("Sub Total : " + subTotal);
		System.out.println("------------------------------");
		
		//get method cetakStrukTransaksi
		cetakStrukTransaksi(scanner, pesanan, subTotal);
	}
	
//	set method cetakStrukTransaksi
	public static void cetakStrukTransaksi(Scanner scanner, SimpanPesanan[] pesanan,double subTotal) {
		boolean isPilihan = true;
		//jika isPilihan true
		while(isPilihan) {
			System.out.print("Cetak Struk Pembayaran (ya/tidak)?: ");
			String isCetak = scanner.nextLine();
			//validasi input menu
			if (!isCetak.matches("ya|tidak")) {
				System.out.println("------------------------------");
			    System.out.println(">>>pilihan tidak ada!<<<");
			    continue;
			} 
			
			//convert string ke boolean
			isCetak = (isCetak.matches("ya")) ? "true" : "false";
			boolean pilihan = Boolean.parseBoolean(isCetak);
			isPilihan = pilihan;
			System.out.println("------------------------------");
			System.out.println("----------Program End---------");
			System.out.println("------------------------------");
			//akhir dari program
			
			//jika pilihan true maka cetak struk transaksi
			if(pilihan == true) {
				System.out.println("\n\n");
				System.out.println("-------Struk Pembayaran-------");
				System.out.println("------------------------------");
				//looping data pesanan
				for(SimpanPesanan data : pesanan) {
					if(data != null) {
						System.out.println("-------- Menu No : " + data.getId() + " ---------");
						System.out.println("------------------------------");
						System.out.println("Nama : " + data.getNama());
						System.out.println("Harga : " + data.getHarga());
						System.out.println("kategori : " + data.getKategori());
						System.out.println("Jumlah : " + data.getJumlah());
						System.out.println("Total : " + (data.getHarga() * data.getJumlah()));
						System.out.println("------------------------------");
					}
				}
				//jika ada promo maka tampilkan
				if(pesanan[5] != null) {
					System.out.println("---------Gratis Minuman-------");
					System.out.println(">>Untuk Promo beli 1 gratis 1<<");
					System.out.println("------------------------------");
					System.out.println("Nama : " + pesanan[5].getNama());
					System.out.println("kategori : " + pesanan[5].getKategori());
					System.out.println("Jumlah : " + pesanan[5].getJumlah());
					System.out.println("------------------------------");
				}
				//tampilkan total transaksi
				System.out.println("------------------------------");
				System.out.println("Sub Total: " + subTotal);
				System.out.println("Biaya Pajak : 10%");
				System.out.println("Biaya Pelayanan : Rp.20.000");
				System.out.println("Grand Total : " + hitungTransaksi(pesanan));
				System.out.println("------------------------------");
				System.out.println("---------Terimah Kasih--------");
				System.out.println("------------------------------");
				
				//set isPilihan menjadi false
				isPilihan = false;
			}
		}
	}
	
	public static int countMenu(ArrayList<MenuItem> menu) {
		int countMenu = 0;
		
		 for (MenuItem item : menu) {
	            if (item != null) {
	                countMenu++;
	            }
	      }
		 return countMenu;
	}
	
}

//class bersarang
//save data menu item child method dari main method
class MenuItem {
	//propert data
	private int id;
	private String nama;
	private double harga;
	private String kategori;
	
	//method save data item
	MenuItem(int id, String nama, double harga, String kategori) {
		this.id = id;
		this.nama = nama;
		this.harga = harga;
		this.kategori = kategori;
	}
	
	//method get data item
	public int getId() {
		return id;
	}
	
	public String getNama() {
		return nama;
	}
	
	public double getHarga() {
		return harga;
	}
	
	public String getKategori() {
		return kategori;
	}
	
	//method set data item	
	public void setId(int id) {
		this.id = id;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
		
	public void setHarga(double harga) {
		this.harga = harga;
	}
		
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
		
}

//save data pesanan  child method dari main method
class SimpanPesanan {
	//prpoerty data
	private int id;
	private String nama;
	private double harga;
	private String kategori;
	private int jumlah;
	
	//method save data
	SimpanPesanan(int id, String nama, double harga, String kategori, int jumlah) {
		this.id = id;
		this.nama = nama;
		this.harga = harga;
		this.kategori = kategori;
		this.jumlah = jumlah;
	}
	
	//method get data
	public int getId() {
		return id;
	}
	
	public String getNama() {
		return nama;
	}
	
	public double getHarga() {
		return harga;
	}
	
	public String getKategori() {
		return kategori;
	}
	
	public int getJumlah() {
		return jumlah;
	}
	
	public double hitungSubTotal() {
		return harga * jumlah;
	}
}










