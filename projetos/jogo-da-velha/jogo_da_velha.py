import random

def print_board(board):
    for row in board:
        print(" | ".join(row))
        print("-" * 5)

def check_winner(board, player):
    
    for i in range(3):
        if all([cell == player for cell in board[i]]): 
            return True
        if all([board[j][i] == player for j in range(3)]):  
            return True
    if all([board[i][i] == player for i in range(3)]):  
        return True
    if all([board[i][2-i] == player for i in range(3)]):  
        return True
    return False


def is_full(board):
    return all([cell != ' ' for row in board for cell in row])

def minimax(board, depth, is_maximizing, alpha, beta):
    if check_winner(board, 'X'):
        return -1  
    if check_winner(board, 'O'):
        return 1  
    if is_full(board):
        return 0  
    if is_maximizing:
        max_eval = -float('inf')
        for i in range(3):
            for j in range(3):
                if board[i][j] == ' ':
                    board[i][j] = 'O'
                    eval = minimax(board, depth + 1, False, alpha, beta)
                    board[i][j] = ' '
                    max_eval = max(max_eval, eval)
                    alpha = max(alpha, eval)
                    if beta <= alpha:
                        break
        return max_eval
    else:
        min_eval = float('inf')
        for i in range(3):
            for j in range(3):
                if board[i][j] == ' ':
                    board[i][j] = 'X'
                    eval = minimax(board, depth + 1, True, alpha, beta)
                    board[i][j] = ' '
                    min_eval = min(min_eval, eval)
                    beta = min(beta, eval)
                    if beta <= alpha:
                        break
        return min_eval


def best_move(board):
    max_eval = -float('inf')
    move = None
    for i in range(3):
        for j in range(3):
            if board[i][j] == ' ':
                board[i][j] = 'O'
                eval = minimax(board, 0, False, -float('inf'), float('inf'))
                board[i][j] = ' '
                if eval > max_eval:
                    max_eval = eval
                    move = (i, j)
    return move

def play_game():
    board = [[' ' for _ in range(3)] for _ in range(3)]
    while True:
        print_board(board)
        
        row, col = map(int, input("Digite a linha e a coluna (0-2) para sua jogada: ").split())
        if board[row][col] != ' ':
            print("Movimento inválido. Tente novamente.")
            continue
        board[row][col] = 'X'
        
        if check_winner(board, 'X'):
            print_board(board)
            print("Você venceu!")
            break
        if is_full(board):
            print_board(board)
            print("Empate!")
            break
        
        print("A IA está jogando...")
        move = best_move(board)
        board[move[0]][move[1]] = 'O'
        
        if check_winner(board, 'O'):
            print_board(board)
            print("A IA venceu!")
            break
        if is_full(board):
            print_board(board)
            print("Empate!")
            break


play_game()

