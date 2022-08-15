package company.Mihayou.Case2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t;
        while (scanner.hasNext()) {
            t = scanner.nextInt();
            for (int i = 0; i < t;i++) {
                int v_ph = scanner.nextInt();
                int v_att = scanner.nextInt();
                int v_def = scanner.nextInt();
                int v_spd = scanner.nextInt();

                int k_ph = scanner.nextInt();
                int k_att = scanner.nextInt();
                int k_def = scanner.nextInt();
                int k_spd = scanner.nextInt();

                int index = 1;
                boolean vb_flag = true;
                boolean vz_flag = false;
                boolean kz_flag = false;
                while (v_ph > 0 && k_ph > 0) {
//                    回合开始
                    if (v_spd > k_spd) {
//                        v先开始攻击
                        if (v_ph < 31 && vb_flag) {
                            vb_flag = false;
                            v_ph += 20;
                            k_ph += 20;
                            v_att += 15;
                        }
//                        主动技能；
                        if (index % 3 ==0) {
                            k_ph -= Math.max((v_att - k_def), 0);
                            k_att += Math.max((v_att - k_def), 0) / 5;
                            vz_flag = true;
                        } else {
                            k_ph -= Math.max((v_att - k_def), 0);
                            k_att += Math.max((v_att - k_def), 0) / 5;
                        }

                        if (k_ph > 0) {
                            if (index % 3 ==0) {
                                if (k_ph >= 11 && !kz_flag) {
                                    k_ph -= 10;
                                    v_ph -=20;
                                    v_ph -= Math.max((k_att - v_def), 0);
                                    kz_flag = true;
                                }
                            } else {
                                if (!kz_flag) {
                                    if (vz_flag == true) {
                                        k_ph -= Math.max((k_att - k_def), 0);
                                        vz_flag = false;
                                    }
                                    v_ph -= Math.max((k_att - v_def), 0);
                                }
                                kz_flag = false;
                            }
                        } else {
                            break;
                        }

                    } else {
//                        k 率先攻击
                        if (index % 3 == 0) {
                            if (k_ph >= 11 && !kz_flag ) {
                                k_ph -= 10;
                                v_ph -= 20;
                                v_ph -= Math.max((k_att - v_def), 0);
                                kz_flag = true;
                            }
                        } else {
                            if (!kz_flag) {
                                if (vz_flag == true) {
                                    k_ph -= Math.max((k_att - k_def), 0);
                                    vz_flag = false;
                                }
                                v_ph -= Math.max((k_att - v_def), 0);
                            }
                            kz_flag = false;
                        }

                        if (v_ph > 0) {
                            if (v_ph < 31 && vb_flag) {
                                vb_flag = false;
                                v_ph += 20;
                                k_ph += 20;
                                v_att += 15;
                            }
                            if (index % 3 ==0) {
                                k_ph -= Math.max((v_att - k_def), 0);
                                k_att += Math.max((v_att - k_def), 0) / 5;
                                vz_flag = true;
                            } else {
                                k_ph -= Math.max((v_att - k_def), 0);
                                k_att += Math.max((v_att - k_def), 0) / 5;
                            }
                        }
                    }
                    index++;
                }

                String res = v_ph > 0 ? "I love V2V forever!" : "Kalpas yame te!";
                System.out.println(res);
            }
        }
    }
}
