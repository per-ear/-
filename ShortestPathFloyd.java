package test7;

import java.util.Scanner;

public class ShortestPathFloyd {
	 
    /** �ڽӾ��� */
    private int[][] matrix;
    /** ��ʾ������ */
    private int MAX_WEIGHT = Integer.MAX_VALUE;
    /**·������*/
    private int[][] pathMatirx;
    /**ǰ����*/
    private int[][] preTable;
 
    /**
     * ����ͼ
     */
    public void createGraph(int index) {
        matrix = new int[index][index];
        //������������ֵ
        int[] A = {0,210,370,MAX_WEIGHT,190,MAX_WEIGHT,MAX_WEIGHT,420};
        int[] B = { 210,0,210,60,480,50,MAX_WEIGHT,250};
        int[] C = {370,210,0,MAX_WEIGHT,320,MAX_WEIGHT,MAX_WEIGHT,210};
        int[] D = {MAX_WEIGHT,60,MAX_WEIGHT,0,MAX_WEIGHT,50,MAX_WEIGHT,MAX_WEIGHT};
        int[] E = { 190,480,320,MAX_WEIGHT,0,MAX_WEIGHT,MAX_WEIGHT,150};
        int[] F = { MAX_WEIGHT,50,MAX_WEIGHT,50,MAX_WEIGHT,0,100,MAX_WEIGHT};
        int[] G = { MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,100,0,60};
        int[] H = { 420,250,210,MAX_WEIGHT,150,MAX_WEIGHT,60,0 };
        //���붥��ֵ
        matrix[0] = A;
        matrix[1] = B;
        matrix[2] = C;
        matrix[3] = D;
        matrix[4] = E;
        matrix[5] = F;
        matrix[6] = G;
        matrix[7] = H;
 
    }
 
    
    
    
    public void floyd(){
        //·������D������ʾ���㵽��������·��Ȩֵ֮�͵ľ��󣬳�ʼʱ������ͼ���ڽӾ���
        pathMatirx = new int[matrix.length][matrix.length];
        //ǰ����P����P[u][n] ��ֵΪ u��n�����·����ǰ�����㣬�����ֱ����ֵΪn��Ҳ���ǳ�ʼֵ
        preTable = new int[matrix.length][matrix.length];
        
        //��ʼ��D,P
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                pathMatirx[i][j] = matrix[i][j];
                preTable[i][j] = j;
            }
        }
        
        //ѭ�� �м侭������
        for (int k = 0; k < matrix.length; k++) {
            //ѭ������·��
            for (int m = 0; m < matrix.length; m++) {
                
                for (int n = 0; n < matrix.length; n++) {
                    
                    int mn = pathMatirx[m][n];
                    int mk = pathMatirx[m][k];
                    int kn = pathMatirx[k][n];
                    int addedPath = (mk == MAX_WEIGHT || kn == MAX_WEIGHT)? MAX_WEIGHT : mk + kn;
                    
                    if (mn > addedPath) {
                        //�������k����·����ԭ����·�����̣��������Ȩֵ��Ϊ��С��һ��
                        pathMatirx[m][n] = addedPath;
                        //ǰ������Ϊ�����±�Ϊk�Ķ���
                        preTable[m][n] = preTable[m][k];
                    }
                    
                }
            }
        }
    }
    
    /**
     * ��ӡ �������·��
     */
    public void print() {
        
//        for (int m = 0; m < matrix.length; m++) {
    	int u=0;//uΪ��Ҫ���ҵص�����ֵ
    	while(u<8) {
    		System.out.println("��ӭ��ʹ��԰���������·����ѯϵͳ:");
			System.out.println("0������¥3");
			System.out.println("1������¥2");
			System.out.println("2������¥1");
			System.out.println("3���˶��㳡");
			System.out.println("4��ʳ��");
			System.out.println("5������");
			System.out.println("6����ͤ");
			System.out.println("7�����й㳡");
			System.out.println("8���˳�ϵͳ");
			 System.out.println("��ѡ������Ҫ��ѯ�ص㵽����������ľ����·����");
    		Scanner sc=new Scanner(System.in);
    		 u=sc.nextInt();
    		 //�ж�����ֵ�Ƿ�<8,�����˳�ϵͳ
    		 if(u<8) {
    			 u=0; 
    		 }
            for (int n = u + 1; n < matrix.length; n++) {
                
                int k = preTable[u][n];
                switch (n) {
                case 0:System.out.print("��ѡ��ص㵽����¥3����:"+pathMatirx[u][n]+"m"+"       ·��Ϊ"+":  ");break;
                case 1:System.out.print("��ѡ��ص㵽����¥2����:"+pathMatirx[u][n]+"m"+"       ·��Ϊ"+":  ");break;
                case 2:System.out.print("��ѡ��ص㵽����¥1����:"+pathMatirx[u][n]+"m"+"       ·��Ϊ"+":  ");break;
                case 3:System.out.print("��ѡ��ص㵽�˶��㳡����:"+pathMatirx[u][n]+"m"+"      ·��Ϊ"+":  ");break;
                case 4:System.out.print("��ѡ��ص㵽ʳ�þ���:"+pathMatirx[u][n]+"m"+"          ·��Ϊ"+":  ");break;
                case 5:System.out.print("��ѡ��ص㵽���򳡾���:"+pathMatirx[u][n]+"m"+"        ·��Ϊ"+":  ");break;
                case 6:System.out.print("��ѡ��ص㵽��ͤ����:"+pathMatirx[u][n]+"m"+"          ·��Ϊ"+":  ");break;
                case 7:System.out.print("��ѡ��ص㵽���й㳡����:"+pathMatirx[u][n]+"m"+"      ·��Ϊ"+":  ");break;
                }
                switch (u) {
                case 0:System.out.print("����¥3");break;
                case 1:System.out.print("����¥2");break;
                case 2:System.out.print("����¥1");break;
                case 3:System.out.print("�˶��㳡");break;
                case 4:System.out.print("ʳ��");break;
                case 5:System.out.print("����");break;
                case 6:System.out.print("��ͤ");break;
                case 7:System.out.print("���й㳡");break;
                } 
                while (k != n) {
                switch (k) {
                case 0:System.out.print("->"+"����¥3");break;
                case 1:System.out.print("->"+"����¥2");break;
                case 2:System.out.print("->"+"����¥1");break;
                case 3:System.out.print("->"+"�˶��㳡");break;
                case 4:System.out.print("->"+"ʳ��");break;
                case 5:System.out.print("->"+"����");break;
                case 6:System.out.print("->"+"��ͤ");break;
                case 7:System.out.print("->"+"���й㳡");break;
                }
                k = preTable[k][n];
                
                }
                switch (n) {
                case 0:System.out.println("->"+"����¥3");break;
                case 1:System.out.println("->"+"����¥2");break;
                case 2:System.out.println("->"+"����¥1");break;
                case 3:System.out.println("->"+"�˶��㳡");break;
                case 4:System.out.println("->"+"ʳ��");break;
                case 5:System.out.println("->"+"����");break;
                case 6:System.out.println("->"+"��ͤ");break;
                case 7:System.out.println("->"+"���й㳡");break;
                } 
            }
            
            System.out.println("............................................");
        }
    	System.out.println("�˳��ɹ�");
        
    }
    
}