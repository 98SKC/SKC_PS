import java.util.*;

class Solution {
    static class Assignment{
        String name;
        int start;
        int end;
        
        public  Assignment(String name,int start,int end){
            this.name=name;
            this.start=start;
            this.end=end;
        } 
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = {};
        int curTime = 0;
        Assignment curAssign = null;
        Assignment nextAssign = null;
        ArrayList<String> arr=new ArrayList<>();
        Stack<Assignment> stack = new Stack<>(); // 중단된 작업을 넣을 스택
        
        Arrays.sort(plans, new Comparator<String[]>(){ // 시작 시간 순으로 정렬
            @Override
            public int compare(String[] o1, String[] o2){
                int numO1 = Integer.parseInt(o1[1].split(":")[0]) * 60 + Integer.parseInt(o1[1].split(":")[1]);
                int numO2 = Integer.parseInt(o2[1].split(":")[0]) * 60 + Integer.parseInt(o2[1].split(":")[1]);
                return Integer.compare(numO1, numO2);
            }
        });
        
        Queue<Assignment> queue = new LinkedList<>();
        for (String[] plan : plans) {
            String name = plan[0];
            int start = Integer.parseInt(plan[1].split(":")[0]) * 60 + Integer.parseInt(plan[1].split(":")[1]);
            int end = Integer.parseInt(plan[2]);
            queue.offer(new Assignment(name, start, end));
        }
        
        while (true) {// 큐가 비면 끝내고 스택 일괄 처리로 넘기.
            if(curAssign==null){// 현재 작업이 없으면 큐에서 가져온다. 즉 처음 작동.
                curAssign=queue.poll();
            }
            //큐 또는 스택에서 가져옴
            //지금 작업이 queue의 작업보다 빨리끝나는지 늦게 끝나는지 확인
            if(queue.isEmpty()){
                arr.add(curAssign.name);
                break;
            }else{// 큐가 안비었으면 다음 과제가 있다는 것이니 미리 확인.
                 nextAssign=queue.peek();
                if(curAssign.start+curAssign.end<nextAssign.start){//다음 작업 시작전까지 여유있음.
                    if(!stack.isEmpty()){// 스택에 남은 일 있음 가져오고, 지금 작업은 마침
                    
                        arr.add(curAssign.name);// 작업이 끝났으니 answer에 추가.
                        nextAssign=stack.pop();// 다음 작업은 queue가 아닌 스텍에서 가져오게 됨
                        curAssign.start+=curAssign.end;// 스텍의 작업의 시작시간은 옛날 시작시간이므로 갱신
                        curAssign.end=nextAssign.end;// 스택에서 가져온 작업의 남은 시간 저장. 
                        curAssign.name=nextAssign.name;
                        /*
                        arr.add(curAssign.name);// 작업이 끝났으니 answer에 추가.
                        nextAssign=stack.pop();// 다음 작업은 queue가 아닌 스텍에서 가져오게 됨
                        nextAssign.start+=nextAssign.end;// 스텍의 작업의 시작시간은 옛날 시작시간이므로 갱신
                        curAssign=nextAssign;
                    */
                    }else{//스택에도 일이 없음 다음 작업 가져옴
                        arr.add(curAssign.name);
                        curAssign=queue.poll();// 작업을 그대로 교체
                    }
                }else if(curAssign.start+curAssign.end==nextAssign.start){// 정확히 교체 가능함
                        arr.add(curAssign.name);// 지금 작업을 마무리
                        curAssign=queue.poll();// 작업을 그대로 교체
                }else if(curAssign.start+curAssign.end>nextAssign.start){// 작업을 마무리 못함-> 스택에 넣어야함
                    curAssign.end-=(nextAssign.start-curAssign.start);// 남은 작업량은 다음시작-지금작업의시작 인 진행도를 빼야함
                    stack.push(curAssign);// 스택에 작업을 저장
                    curAssign=queue.poll();// 작업 교체
                }
            }
        }
        // 스택에 남은 작업을 완료
        while (!stack.isEmpty()) {
            curAssign = stack.pop();
            arr.add(curAssign.name); // 과제 완료 목록에 추가
        }

        answer = arr.toArray(new String[arr.size()]);
        return answer;
    }
}