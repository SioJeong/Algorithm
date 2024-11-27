class MinHeap {
    constructor() {
        this.heap = [];
    }
    
    // 부모 노드의 인덱스 계산
    getParent(index) {
        return Math.floor((index - 1) / 2);
    }
    
    // 왼쪽 자식 노드의 인덱스 계산
    getLeftChild(index) {
        return index * 2 + 1;
    }
    
    // 오른쪽 자식 노드의 인덱스 계산
    getRightChild(index) {
        return index * 2 + 2;
    }
    
    push(value) {
        this.heap.push(value);
        this.heapifyUp();
    }
    
    pop() {
        if(this.heap.length === 0) {
            return null;
        }
        
        if(this.heap.length === 1) {
            return this.heap.pop();
        }
        
        const root = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.heapifyDown();
        return root;
    }
    
    // 힙의 최상위 값
    peek() {
        return this.heap.length > 0 ? this.heap[0] : null;
    }
    
    // 힙을 위로 재정렬
    heapifyUp() {
        let index = this.heap.length - 1;
        
        while(index > 0 && this.heap[index] < this.heap[this.getParent(index)]) {
            const parent = this.getParent(index);
            [this.heap[index], this.heap[parent]] = [this.heap[parent], this.heap[index]];
            index = parent;
        }
    }
    
    // 힙을 아래로 재정렬
    heapifyDown() {
        let index = 0;
        
        while(this.getLeftChild(index) < this.heap.length) {
            let smallerChild = this.getLeftChild(index);
            const rightChild = this.getRightChild(index);
            
            if(rightChild < this.heap.length && this.heap[rightChild] < this.heap[smallerChild]) {
                smallerChild = rightChild;
            }
            
            if(this.heap[index] <= this.heap[smallerChild]) {
                break;
            }
            
            [this.heap[index], this.heap[smallerChild]] = [this.heap[smallerChild], this.heap[index]];
            
            index = smallerChild;
        }
    }
}

function solution(scoville, K) {
    const heap = new MinHeap();
    
    for(const s of scoville) {
        heap.push(s);
    }
    
    let answer = 0;
    
    while(heap.peek() !== null && heap.peek() < K) {
        if(heap.heap.length < 2) return -1;
        
        const first = heap.pop();
        const second = heap.pop();
        const newFood = first + second * 2;
        heap.push(newFood);
        answer++;
    }
    
    return answer;
}
